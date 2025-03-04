import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        int i = 0;
        String idk = "";
        int idx = 0;
        while (idx < s.length()) {
            idk = String.valueOf(s.charAt(idx));
            if (idk.equals("(")) {
                i++;
            } else if (idk.equals(")")) {
                i--;
            } else if (i < 0) {
                return false;
            }
            idx++;
        }
        return i == 0;
    }

    private void checkFile(String filename) {

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(isBalanced(data));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // open file named filename

            // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

            // CLOSE the file
        }
    }

        public static void main (String[]args){
            ParenSymmetry ps = new ParenSymmetry();
            ps.checkFile("TestStrings0.txt");
            Boolean b0 = ps.isBalanced("()");
            printResult(b0, true);

            String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
            Boolean falses = true;
            for (String strToTest : falseStrings) {
                falses = ps.isBalanced(strToTest);
            }
            printResult(falses, false);

            String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
            Boolean trues = false;
            for (String strToTest : trueStrings) {
                trues = ps.isBalanced(strToTest);
            }
            printResult(trues, true);

        }

        private static void printResult (Boolean b0,boolean b){
            if (b0 == null) {
                System.out.println("Null Failure");
                return;
            }
            if (b0 == b) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        }
    }
