import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        /*
         * Write your code here.
         */
        double p=0,n=0,z=0;

        for (int i=0;i<arr.length;i++) {
            if(arr[i] > 0){
                p++;
            }
            else if(arr[i] < 0){
                n++;
            }
            else{
                z++;
            }
        }
        System.out.printf("%.5f\n",(p/(arr.length)));
        System.out.printf("%.5f\n",(n/(arr.length)));
        System.out.printf("%.5f\n",(z/(arr.length)));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}