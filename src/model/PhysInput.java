package model;

/**
 * Created by Owner on 5/8/2017.
 */
public class PhysInput{

    public String[] input;

    /**
     * Initialization of PhysInput
     */
    public PhysInput() {
        // input[0] = initial velocity
        // input[1] = displacement
        // input[2] = acceleration
        // input[3] = time taken
        input = new String[] {"NULL", "NULL", "NULL", "NULL"};
    }

    public String calculate() {
        double u, s, a, t, v;
        if (input[1].equals("NA")) {
            u = Double.parseDouble(input[0]);
            a = Double.parseDouble(input[2]);
            t = Double.parseDouble(input[3]);
            v = u + a*t;
            return "Final velocity is " + v + "m/s \nFormula used: v = u + a*t";
        }
        if (input[3].equals("NA")) {
            u = Double.parseDouble(input[0]);
            s = Double.parseDouble(input[1]);
            a = Double.parseDouble(input[2]);
            v = Math.sqrt(u*u+2*a*s);
            return "Final velocity is " + v + "m/s \nFormula used: v^2 = u^2 + 2*a*s";
        }
        else return "Work in progress";
    }

    /**
     * Todo: for reset button
     */
    private void clearInput() {
        input[0] = "NULL";
        input[1] = "NULL";
        input[2] = "NULL";
        input[3] = "NULL";
    }
}
