import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
       Arrays.sort(a);
        Arrays.sort(b);
        int [] tmp;
        if (a[a.length-1]>=b[0]) {
            tmp = a;
            a = b;
            b = tmp;
        }
       System.out.println(a[0]+" "+b[0]);
        String list = "";
        int count = 0;
        boolean check = false;
        for (int i=1;a[a.length-1]*i<=b[0];i++) {
            //System.out.println(a[a.length-1]*i);
            check = false;
            for (int j=0;j<a.length;j++) {
                if (a[a.length-1]*i % a[j] == 0) {
                    check = true;
                }
                else {
                    check =false;
                    break;
                }
            }
            if (check){
                if (a[a.length-1]*i==b[0])
                    list = list + a[a.length-1]*i;
                else
                    list = list + a[a.length-1]*i + ",";
            }

        }
        System.out.println(list);
        if (!list.isEmpty()) {
            String[] parts = list.split(",");
//        for (int i=0;i<parts.length;i++)
//            System.out.println(parts[i]);
            for (int i=0;i<parts.length;i++) {
                check = false;
                for (int j=0;j<b.length;j++) {
                    if (b[j]%(Integer.parseInt(parts[i])) == 0) {
                        check = true;
                    }
                    else {
                        check =false;
                        break;
                    }
                }
                if (check){
                    System.out.println(Integer.parseInt(parts[i]));
                    count++;
                }

            }
        }


        return count;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}