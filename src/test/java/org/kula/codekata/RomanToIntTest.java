package org.kula.codekata;

import junit.framework.TestCase;
import org.junit.Assert;

public class RomanToIntTest extends TestCase {

    public void testTestRun() {
        RomanToInt.Solution p = new RomanToInt.Solution();
        Assert.assertEquals(p.romanToInt("MCMXCIV"), 1994);
    }

}