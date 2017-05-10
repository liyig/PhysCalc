package model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created by Owner on 5/8/2017.
 */
public class PhysInputTest {

    PhysInput testInput;

    @Before
    public void runBefore() {
        testInput = new PhysInput();
    }

    @Test
    public void testCalculateV() {
        testInput.input[0] = "1";
        //testInput.convertToDouble();
        //assertEquals(testInput.input[0], Double.toString(testInput.converted[0]));

    }



}