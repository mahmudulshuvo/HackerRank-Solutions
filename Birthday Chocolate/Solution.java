import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int total=0,count=0,ways=0;
        int len = s.length;

        for (int i=0;i<len;i++) {
            total=0;
            count=0;

            for (int j=i;j>=0;j--) {
                total += s[j];
                count++;

                if (total == d && count == m) {
                    ways++;
                    break;
                }

                else if (total < d && count < m) {
                    continue;
                }

                else {
                    break;
                }

            }

            total = 0;
            count = 0;

            for (int j=i;j<len;j++) {
                total += s[j];
                count++;

                if (total == d && count == m) {
                    ways++;
                    break;
                }

                else if (total < d && count < m) {
                    continue;
                }

                else {
                    break;
                }

            }
        }

        return ways/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}