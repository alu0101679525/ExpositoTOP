package main.java.top;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.es.ull.esit.utilities.ExpositoUtilities;

/**
 * @class TOPTWReader
 * @brief Clase utilitaria para la lectura de instancias del problema desde ficheros de texto.
 */
public class TOPTWReader {

    private TOPTWReader() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @brief Lee un fichero de instancia y construye un objeto TOPTW con sus datos.
     * @param filePath Ruta del fichero de texto que contiene la definición de la instancia.
     * @return Objeto TOPTW completamente inicializado con los datos del fichero.
     */
    public static TOPTW readProblem(String filePath) {
        Logger logger = Logger.getLogger(TOPTWReader.class.getName());
        TOPTW problem = null;
        File instaceFile = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(instaceFile))) {
            String line = reader.readLine();
            line = ExpositoUtilities.simplifyString(line);
            String[] parts = line.split(" ");
            problem = new TOPTW(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]));
            line = reader.readLine();

            for (int i = 0; i < problem.getPOIs()+1; i++) {
                line = reader.readLine();
                line = ExpositoUtilities.simplifyString(line);
                parts = line.split(" ");
                problem.setX(i, Double.parseDouble(parts[1]));
                problem.setY(i, Double.parseDouble(parts[2]));
                problem.setServiceTime(i, Double.parseDouble(parts[3]));
                problem.setScore(i, Double.parseDouble(parts[4]));
                if(i==0) {
                    problem.setReadyTime(i, Double.parseDouble(parts[7]));
                    problem.setDueTime(i, Double.parseDouble(parts[8]));
                }
                else {
                    problem.setReadyTime(i, Double.parseDouble(parts[8]));
                    problem.setDueTime(i, Double.parseDouble(parts[9]));
                }
            }
            problem.calculateDistanceMatrix();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading problem file", e);
            System.exit(0);
        }
        problem.setMaxTimePerRoute(problem.getDueTime(0));
        return problem;
    }
}