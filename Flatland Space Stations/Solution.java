import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

        int len = c.length,left=1000000,right=1000000;
        int[] citis = new int[n];

        for (int i=0;i<len;i++) {
            citis[c[i]] = -1;
        }

        Arrays.sort(c);

        if (len>1) {

            for (int i=0;i<n;i++) {
                if (citis[i] != -1) {
                    left=1000000;right=1000000;

                    for (int j=i-1;j>=0;j--) {
                        if (citis[j] == -1) {
                            left = i-j;
                            break;
                        }
                    }

                    for (int j=i+1;j<n;j++) {
                        if (citis[j] == -1) {
                            right = j-i;
                            break;
                        }
                    }
                    citis[i] = (left<=right)? left:right;

                }
            }

        }

        else {
            for (int i=0;i<n;i++) {
                if (citis[i] != -1)
                    citis[i] = Math.abs(i-c[0]);
            }
        }

        int max=-2;
        for (int i=0;i<n;i++) {
            max = citis[i]>max? citis[i]:max;
        }
        return max==-1?0:max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}