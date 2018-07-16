import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner6;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] rankings = new int[scores.length];
        rankings[0] = 1;
        for(int i=1; i<scores.length; i++){
            if(scores[i] == scores[i-1])
                rankings[i] = rankings[i-1];
            else
                rankings[i] = rankings[i-1] + 1;
        }

        for(int i=0; i<scores.length; i++){
            System.out.println(rankings[i]);
        }
        System.out.println("done validating rankings");


        int[] solutions = new int[alice.length];
        for(int j=0; j<alice.length; j++){
            int checkLimit = scores.length;
            for(int i=0; i<checkLimit; i++){
                if((alice[j] == scores[i]) || (alice[j] > scores[i])){
                    solutions[j] = rankings[i];
                    checkLimit = i;
                    break;
                }
            }
            if(solutions[j] == 0 && checkLimit <= 1)
                solutions[j] = 1;
            if(solutions[j] == 0)
                solutions[j] = rankings[rankings.length-1]+1;
        }
        return solutions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
