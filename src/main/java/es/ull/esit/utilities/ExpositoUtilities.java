package main.java.es.ull.esit.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpositoUtilities {

    public static final int DEFAULT_COLUMN_WIDTH = 10;
    public static final int ALIGNMENT_LEFT = 1;
    public static final int ALIGNMENT_RIGHT = 2;

    private ExpositoUtilities() {
        throw new IllegalStateException("Utility class");
    }

    public static void printFile(String file) {
        Logger logger = Logger.getLogger(ExpositoUtilities.class.getName());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error reading file", ex);
        }
    }

    public static String simplifyString(String string) {
        String result = string.replace("\t", " ");
        for (int i = 0; i < 50; i++) {
            result = result.replace("  ", " ");
        }
        return result.trim();
    }

    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        if (a.length == 0 || a[0].length != b.length) {
            return new double[0][0];
        }
        int n = a[0].length;
        int m = a.length;
        int p = b[0].length;
        double[][] ans = new double[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    public static void writeTextToFile(String file, String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
            writer.flush();
        }
    }

    public static String getFormat(String string) {
        if (!ExpositoUtilities.isInteger(string) && ExpositoUtilities.isDouble(string)) {
            double value = Double.parseDouble(string);
            return ExpositoUtilities.getFormat(value);
        }
        return string;
    }

    public static String getFormat(double value) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.000");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormatter.setDecimalFormatSymbols(symbols);
        return decimalFormatter.format(value);
    }

    public static String getFormat(double value, int zeros) {
        StringBuilder format = new StringBuilder("0.");
        for (int i = 0; i < zeros; i++) {
            format.append("0");
        }
        DecimalFormat decimalFormatter = new DecimalFormat(format.toString());
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormatter.setDecimalFormatSymbols(symbols);
        return decimalFormatter.format(value);
    }

    public static String getFormat(String string, int width) {
        return ExpositoUtilities.getFormat(string, width, ExpositoUtilities.ALIGNMENT_RIGHT);
    }

    public static String getFormat(String string, int width, int alignment) {
        String format = "";
        if (alignment == ExpositoUtilities.ALIGNMENT_LEFT) {
            format = "%-" + width + "s";
        } else {
            format = "%1$" + width + "s";
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        String[] data = new String[]{string};
        return String.format(format, (Object[]) data);
    }

    public static String getFormat(List<String> strings, int width) {
        StringBuilder format = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            format.append("%").append(i + 1).append("$").append(width).append("s");
        }
        String[] data = new String[strings.size()];
        for (int t = 0; t < strings.size(); t++) {
            data[t] = ExpositoUtilities.getFormat(strings.get(t));
        }
        return String.format(format.toString(), (Object[]) data);
    }

    public static String getFormat(List<Integer> strings) {
        StringBuilder format = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            format.append("%").append(i + 1).append("$").append(DEFAULT_COLUMN_WIDTH).append("s");
        }
        Integer[] data = new Integer[strings.size()];
        for (int t = 0; t < strings.size(); t++) {
            data[t] = strings.get(t);
        }
        return String.format(format.toString(), (Object[]) data);
    }

    public static String getFormat(String[] strings, int width) {
        int[] alignment = new int[strings.length];
        Arrays.fill(alignment, ExpositoUtilities.ALIGNMENT_RIGHT);
        int[] widths = new int[strings.length];
        Arrays.fill(widths, width);
        return ExpositoUtilities.getFormat(strings, widths, alignment);
    }

    public static String getFormat(String[][] matrixStrings, int width) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrixStrings.length; i++) {
            String[] strings = matrixStrings[i];
            int[] alignment = new int[strings.length];
            Arrays.fill(alignment, ExpositoUtilities.ALIGNMENT_RIGHT);
            int[] widths = new int[strings.length];
            Arrays.fill(widths, width);
            result.append(ExpositoUtilities.getFormat(strings, widths, alignment));
            if (i < (matrixStrings.length - 1)) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String getFormat(String[] strings) {
        int[] alignment = new int[strings.length];
        Arrays.fill(alignment, ExpositoUtilities.ALIGNMENT_RIGHT);
        int[] widths = new int[strings.length];
        Arrays.fill(widths, ExpositoUtilities.DEFAULT_COLUMN_WIDTH);
        return ExpositoUtilities.getFormat(strings, widths, alignment);
    }

    public static String getFormat(String[] strings, int[] width) {
        int[] alignment = new int[strings.length];
        Arrays.fill(alignment, ExpositoUtilities.ALIGNMENT_RIGHT);
        return ExpositoUtilities.getFormat(strings, width, alignment);
    }

    public static String getFormat(String[] strings, int[] width, int[] alignment) {
        StringBuilder format = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (alignment[i] == ExpositoUtilities.ALIGNMENT_LEFT) {
                format.append("%").append(i + 1).append("$-").append(width[i]).append("s");
            } else {
                format.append("%").append(i + 1).append("$").append(width[i]).append("s");
            }
        }
        String[] data = new String[strings.length];
        for (int t = 0; t < strings.length; t++) {
            data[t] = ExpositoUtilities.getFormat(strings[t]);
        }
        return String.format(format.toString(), (Object[]) data);
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isAcyclic(int[][] distanceMatrix) {
        int numRealTasks = distanceMatrix.length - 2;
        int node = 1;
        while (node <= numRealTasks) {
            if (ExpositoUtilities.thereIsPath(distanceMatrix, node)) {
                return false;
            }
            node++;
        }
        return true;
    }

    public static boolean thereIsPath(int[][] distanceMatrix, int node) {
        Set<Integer> visits = new HashSet<>();
        Set<Integer> noVisits = new HashSet<>();
        for (int i = 0; i < distanceMatrix.length; i++) {
            if (i != node) {
                noVisits.add(i);
            }
        }
        visits.add(node);
        while (!visits.isEmpty()) {
            Iterator<Integer> it = visits.iterator();
            int toCheck = it.next();
            visits.remove(toCheck);
            if (processNodeConnections(distanceMatrix, node, toCheck, noVisits, visits)) {
                return true;
            }
        }
        return false;
    }

    private static boolean processNodeConnections(int[][] distanceMatrix, int node, int toCheck, Set<Integer> noVisits, Set<Integer> visits) {
        for (int i = 0; i < distanceMatrix.length; i++) {
            if (toCheck != i && distanceMatrix[toCheck][i] != Integer.MAX_VALUE) {
                if (i == node) {
                    return true;
                }
                if (noVisits.contains(i)) {
                    noVisits.remove(i);
                    visits.add(i);
                }
            }
        }
        return false;
    }
}