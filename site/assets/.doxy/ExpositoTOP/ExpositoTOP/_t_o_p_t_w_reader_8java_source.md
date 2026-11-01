

# File TOPTWReader.java

[**File List**](files.md) **>** [**java**](dir_fd3f6763802dee1ad875f6c80eac0bda.md) **>** [**top**](dir_6ff67e08b8bc917d9697c3f221534daa.md) **>** [**TOPTWReader.java**](_t_o_p_t_w_reader_8java.md)

[Go to the documentation of this file](_t_o_p_t_w_reader_8java.md)


```Java
package main.java.top;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.es.ull.esit.utilities.ExpositoUtilities;

public class TOPTWReader {

    private TOPTWReader() {
        throw new IllegalStateException("Utility class");
    }

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
```


