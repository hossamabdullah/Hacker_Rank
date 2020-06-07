import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private final static int IMPORTANT_CONTEST = 1;
    private final static int URGENCY_INDEX = 1;
    private final static int LUCK_INDEX = 0;

    static int luckBalance(int k, int[][] contests){
        int[] importantContests = new int[contests.length];
        int importantContestsIndex = 0;
        int resultLuck = 0;
        for(int i=0; i<contests.length; i++){
            if(contests[i][URGENCY_INDEX] == IMPORTANT_CONTEST)
                importantContests[importantContestsIndex++] = contests[i][LUCK_INDEX];
            else
                resultLuck += contests[i][LUCK_INDEX];
        }

        Arrays.sort(importantContests);

        k = contests.length - k;
        for(int contest: importantContests){
            if(k-- > 0)
                resultLuck -= contest;    
            else
                resultLuck += contest;
        }
        return resultLuck;
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

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
