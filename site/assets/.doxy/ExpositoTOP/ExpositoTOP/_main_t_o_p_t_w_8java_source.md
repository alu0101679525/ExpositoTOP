

# File MainTOPTW.java

[**File List**](files.md) **>** [**java**](dir_fd3f6763802dee1ad875f6c80eac0bda.md) **>** [**top**](dir_6ff67e08b8bc917d9697c3f221534daa.md) **>** [**MainTOPTW.java**](_main_t_o_p_t_w_8java.md)

[Go to the documentation of this file](_main_t_o_p_t_w_8java.md)


```Java
package main.java.top;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTOPTW {
    private static final Logger logger = Logger.getLogger(MainTOPTW.class.getName());

    public static void main(String[] args) {
        String[] instances = new String[29];

        instances[0] = "c101.txt"; instances[3] = "c104.txt"; instances[6] = "c107.txt";
        instances[1] = "c102.txt"; instances[4] = "c105.txt"; instances[7] = "c108.txt";
        instances[2] = "c103.txt"; instances[5] = "c106.txt"; instances[8] = "c109.txt";

        instances[9] = "r101.txt";  instances[12] = "r104.txt"; instances[15] = "r107.txt";
        instances[10] = "r102.txt"; instances[13] = "r105.txt"; instances[16] = "r108.txt";
        instances[11] = "r103.txt"; instances[14] = "r106.txt"; instances[17] = "r109.txt";
        instances[18] = "r110.txt"; instances[19] = "r111.txt"; instances[20] = "r112.txt";

        instances[21] = "rc101.txt"; instances[24] = "rc104.txt"; instances[27] = "rc107.txt";
        instances[22] = "rc102.txt"; instances[25] = "rc105.txt"; instances[28] = "rc108.txt";
        instances[23] = "rc103.txt"; instances[26] = "rc106.txt";

        for(int i = 0; i < instances.length; i++) {
            String instance = "Instances/TOPTW/"+instances[i];
            TOPTW problem = TOPTWReader.readProblem(instance);
            TOPTWSolution solution = new TOPTWSolution(problem);
            TOPTWGRASP graspObj = new TOPTWGRASP(solution);

            if(logger.isLoggable(Level.INFO)) {
                logger.info(String.format(" --> Instance: %s", instances[i]));
            }
            graspObj.grasp(10000, 3);
            graspObj.grasp(10000, 5);
            graspObj.grasp(10000, 7);
            logger.info("");
        }
    }
}
```


