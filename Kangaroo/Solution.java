import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        double ret = 0.0;

        if ((x1-x2) == 0 && ((v2-v1) == 0)) {
            return "YES";
        }

        else if ((x1-x2) == 0 || (v2-v1) == 0) {
            return "NO";
        }

        else {
            ret = (double) (x1-x2)/(double) (v2-v1);
            if (ret < 0)
                return "NO";
            else {
                if (ret % 1 == 0)
                    return "YES";
                else
                    return "NO";
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}