import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private final static int IMPORTANT_CONTEST = 1;

    //ic -> importantContest
    static int luckBalance(int n, int k, int[][] contests) {
        int[] icLuck = new int[n];
        int icIndex = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            if(contests[i][1] == IMPORTANT_CONTEST){
                icLuck[icIndex] = contests[i][0];
                icIndex++;
            }else{
                sum += contests[i][0];
            }
        }

        Arrays.sort(icLuck);
        // System.out.println(n-k-1);
        // for(int i=n-1; i>=0; i--){
        //     System.out.println(i+", "+icLuck[i]);
        // }
        // System.out.println(sum);
        for(int i=n-1; i > n-k-1; i--){
            sum+=icLuck[i];
        }
        // System.out.println(sum);
        for(int i=n-k-1; i>=0; i--){
            sum-=icLuck[i];
        }

        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(n, k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
