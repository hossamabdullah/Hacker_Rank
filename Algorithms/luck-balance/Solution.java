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

    static int luckBalance(int contestsToLoose, int[][] contests){
        List<Integer> important = new ArrayList<>();
        int luck = 0;
        for(int[] contest: contests){
            if(contest[URGENCY_INDEX] == IMPORTANT_CONTEST)
                important.add(contest[LUCK_INDEX]);
            else
                luck += contest[LUCK_INDEX];
        }

        Collections.sort(important);
        int contestsToWin = important.size() - contestsToLoose;

        for(int contest: important){
            if(contestsToWin-- > 0)
                luck -= contest;
            else
                luck += contest;
        }

        return luck;
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
