import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int i = sticks.length - 3;
        while(i >= 0 && (sticks[i] + sticks[i+1] <= sticks[i+2] ) )
            i--;
        
        int[] res;
        if(i >= 0)
            res = new int[]{sticks[i], sticks[i+1], sticks[i+2]};
        else
            res = new int[]{0,0,0};
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        if(result[0]==0 && result[1]==0 && result[2]==0){
            bufferedWriter.write("-1");
        }else
            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
