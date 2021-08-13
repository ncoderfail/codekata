package org.kula.codekata;

import org.apache.commons.cli.*;

/**
 * Palindrome of an integer
 *
 */
public class Palindrome implements Solution<Boolean> {

    static class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }

            String xstr = String.valueOf(x);
            for(int i = xstr.length() - 1; i >= xstr.length()/2; --i) {
                if(xstr.charAt(i) != xstr.charAt(xstr.length() - 1 - i)){
                    return false;
                }
            }

            return true;
        }
    }

    class Solution2 {
        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }

            int temp = x;
            int reverse = 0;

            while(temp > 0){
                int rem = temp % 10;
                reverse = reverse * 10 + rem;
                temp = temp/10;
            }

            if(reverse == x){
                return true;
            }

            return false;
        }
    }

    public static void main( String[] args ) {
        Options options = new Options();
        Option option = Option.builder().longOpt("number").argName("n").required(true).desc("Find if this number is a plaindrome").numberOfArgs(1).build();
        options.addOption(option);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        Palindrome problem = new Palindrome();
        try {
            CommandLine cmd = parser.parse(options, args);
            problem.run(cmd);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Palindrome", options);
            System.exit(1);
        }

    }

    @Override
    public Boolean run(CommandLine cmd) {
        int num = Integer.parseInt(cmd.getOptionValue("number"));
        Solution sol = new Solution();
        boolean bOK = sol.isPalindrome(num);
        if(bOK) {
            System.out.println(num + " is a plaindrome");
        } else {
            System.out.println(num + " is not a plaindrome");
        }
        return bOK;
    }
}
