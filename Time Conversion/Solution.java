import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] parts = s.split(":");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        String time = "";

        if (part3.charAt(2) == 'A') {
            if (Integer.parseInt(part1) == 12){
                part1 = "00";
                time = part1+":"+part2+":"+part3.substring(0,2);
            }
            else {
                time = part1+":"+part2+":"+part3.substring(0,2);
            }
        }

        else {
            if (Integer.parseInt(part1) == 12) {
                time = part1+":"+part2+":"+part3.substring(0,2);
            }
            else {
                 part1 = String.valueOf((Integer.parseInt(part1) + 12));
                 time = part1+":"+part2+":"+part3.substring(0,2);
            }
        }

        return time;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}