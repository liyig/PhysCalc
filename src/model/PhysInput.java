package model;

import java.util.ArrayList;
import static java.sql.Types.NULL;


/**
 * Created by Owner on 5/8/2017.
 */
public class PhysInput extends ArrayList{

    // input[0] = initial velocity
    // input[1 = displacement
    // input[2] = acceleration
    // input[3] = time taken
    public String[] input = {"NULL", "NULL", "NULL", "NULL"};
    public double[] converted = {NULL, NULL, NULL, NULL};


    public PhysInput() {
        // Constructor
    }


    public String calculate() {
        return "shad";

    }

    private void clearInput() {
        input[0] = "NULL";
        input[1] = "NULL";
        input[2] = "NULL";
        input[3] = "NULL";
    }
}
