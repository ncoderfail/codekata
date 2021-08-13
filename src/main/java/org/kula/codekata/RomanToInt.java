package org.kula.codekata;

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class RomanToInt implements Solution<Integer> {

    public static Map<String, Integer> dictionary = new HashMap<>();

    static {
        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);
        dictionary.put("IV", 4);
        dictionary.put("IX", 9);
        dictionary.put("XL", 40);
        dictionary.put("XC", 90);
        dictionary.put("CD", 400);
        dictionary.put("CM", 900);
    }

    public static class Solution {

        public int romanToInt(String s) {
            Queue<String> queue = new ArrayBlockingQueue<String>(100);
            for(String k: s.split("")){
                queue.add(k);
            }

            int num = 0;
            while(!queue.isEmpty()){

                String first = queue.poll();
                String second = queue.peek();
                if(dictionary.containsKey(first + second)){
                    queue.poll();
                    num += dictionary.get(first + second);
                } else {
                    if(dictionary.containsKey(first)){
                        num += dictionary.get(first);
                    } else {
                        throw new IllegalArgumentException("Not a legal roman numeral");
                    }
                }
            }

            return num;
        }
    }

    @Override
    public Integer run(CommandLine cmd) {
        String roman = cmd.getOptionValue("roman");
        RomanToInt.Solution sol = new RomanToInt.Solution();
        int num = sol.romanToInt(roman);
        System.out.println(num);
        return num;
    }

    public static void main( String[] args ) {
        Options options = new Options();
        Option option = Option.builder().longOpt("roman").argName("r").required(true).desc("Convert roman to int").numberOfArgs(1).build();
        options.addOption(option);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        RomanToInt problem = new RomanToInt();
        try {
            CommandLine cmd = parser.parse(options, args);
            problem.run(cmd);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("RomanToInt", options);
            System.exit(1);
        }

    }
}
