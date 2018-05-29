import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        
        int total = 0;
        int left=c_q-1,right=n-c_q,up=n-r_q,down=r_q-1;
        int leftUp = left<=up ? left : up;
        int leftDown = left<=down ? left : down;
        int rightUp = right<=up ? right : up;
        int rightDown= right<=down ? right : down;


        for (int i=0;i<k;i++) {

            if (obstacles[i][0] == r_q) { // check if obstacle is on same row

                if (obstacles[i][1] < c_q) { // obstacle is on same row left position

                    if (left != 0) {
                        left = (c_q-obstacles[i][1]-1) < left ? (c_q-obstacles[i][1]-1) : left;
                    }
                }

                else {  // obstacle is on same row right position

                    if (right != 0) {
                        right = (obstacles[i][1]-c_q-1) < right ? (obstacles[i][1]-c_q-1) : right;
                    }

                }
            }

            else if (obstacles[i][1] == c_q) { // check if obstacle is on same col

                if (obstacles[i][0] < r_q) { // obstacle is on same col down position

                    if (down != 0) {
                        down = (r_q-obstacles[i][0]-1) < down ? (r_q-obstacles[i][0]-1)  : down;
                    }
                }

                else {  // obstacle is on same col up position

                    if (up != 0) {
                        up = (obstacles[i][0]-r_q-1) < up ? (obstacles[i][0]-r_q-1) : up;
                    }

                }

            }

            else {

                if (obstacles[i][1]<c_q) { // check if obstacle is on left

                    if (obstacles[i][0] > r_q) { // obstacle is in left-up

                        if (leftUp != 0) {

                            if (Math.abs(r_q-obstacles[i][0]) == Math.abs(c_q-obstacles[i][1])) {

                                leftUp = (obstacles[i][0]-1-r_q) < leftUp ? (obstacles[i][0]-1-r_q) : leftUp;
                            }
                        }
                    }

                    else { // obstacle is in left-down

                        if (leftDown != 0) {

                            if (Math.abs(r_q-obstacles[i][0]) == Math.abs(c_q-obstacles[i][1])) {
                                leftDown = (r_q-obstacles[i][0]-1) < leftDown ? (r_q-obstacles[i][0]-1) : leftDown;
                            }
                        }

                    }
                }

                else { // obstacle is in right

                    if (obstacles[i][0] > r_q) { // obstacle is in right-up

                        if (rightUp != 0) {

                            if (Math.abs(r_q-obstacles[i][0]) == Math.abs(c_q-obstacles[i][1])) {
                                rightUp = (obstacles[i][0]-1-r_q) < rightUp ? (obstacles[i][0]-1-r_q) : rightUp;
                            }
                        }

                    }

                    else { // obstacle is in right-down

                        if (rightDown != 0) {

                            if (Math.abs(r_q-obstacles[i][0]) == Math.abs(c_q-obstacles[i][1])) {
                                rightDown = (r_q-obstacles[i][0]-1) < rightDown ? (r_q-obstacles[i][0]-1) : rightDown;
                            }
                        }

                    }
                }
            }
        }

        total = left+right+up+down+leftUp+leftDown+rightUp+rightDown;

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
