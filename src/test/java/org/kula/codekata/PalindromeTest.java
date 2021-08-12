package org.kula.codekata;

import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromeTest extends TestCase {

    public void testTestRun() {
        Palindrome.Solution p = new Palindrome.Solution();
        Assert.assertTrue(p.isPalindrome(121));
        Assert.assertFalse(p.isPalindrome(-121));
        Assert.assertFalse(p.isPalindrome(1212));
    }

}