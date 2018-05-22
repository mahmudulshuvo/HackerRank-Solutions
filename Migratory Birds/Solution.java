import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
                HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=1;i<=5;i++)
            map.put(i,0);
        int len = ar.length;
        int val = 0;
        for (int i=0;i<len;i++) {
            val = map.get(ar[i]);
            map.put(ar[i],++val);
        }
        val = 0;
        int index = 0;
        for (int i=1;i<=5;i++) {
            if (map.get(i) > val) {
                val = map.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
