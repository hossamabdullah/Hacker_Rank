import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner6;

class Rank{
    public int score;
    public boolean isAlice;
    public int rank;

    public Rank(int score, boolean isAlice){
        this.score = score;
        this.isAlice = isAlice;
    }

    public Rank(int score, boolean isAlice, int rank){
        this.score = score;
        this.isAlice = isAlice;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return score+", "+isAlice+", "+rank;
    }
}

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int fullLength = scores.length + alice.length;
        Rank[] rankings = new Rank[fullLength];
        
        int minLength = 0;
        if(scores.length < alice.length)
            minLength = scores.length;
        else   
            minLength = alice.length;
        
        //Merge concatenation
        for(int i=0; i<minLength; i++){
            Rank temp = null;
            if(scores[i] > alice[i]){
                temp = new Rank(scores[i], false);
            }else{
                temp = new Rank(alice[i], true);
            }
            
            if(i==0)
                temp.rank = 1;
            else if(temp.score == rankings[i-1].score)
                temp.rank = rankings[i-1].rank;
            else if(!rankings[i-1].isAlice)
                temp.rank = rankings[i-1].rank + 1;
            else
                temp.rank = rankings[i-1].rank;

            rankings[i] = temp;
        }

        int index = minLength;
        while(minLength < scores.length){
            Rank temp = new Rank(scores[index], false);
            if(temp.score == rankings[index-1].score)
                temp.rank = rankings[index-1].rank;
            else if(!rankings[index-1].isAlice)
                temp.rank = rankings[index-1].rank + 1;
            else
                temp.rank = rankings[index-1].rank;
            rankings[index] = temp;
            index ++;
        }

        index = minLength;
        while(minLength < alice.length){
            Rank temp = new Rank(scores[index], true);
            if(temp.score == rankings[index-1].score)
                temp.rank = rankings[index-1].rank;
            else if(!rankings[index-1].isAlice)
                temp.rank = rankings[index-1].rank + 1;
            else
                temp.rank = rankings[index-1].rank;
            rankings[index] = temp;
            index ++;
        }
        
        for(int i=0; i<rankings.length; i++){
            System.out.println(rankings[i]);
        }
        return null;
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

        // for (int i = 0; i < result.length; i++) {
        //     bufferedWriter.write(String.valueOf(result[i]));

        //     if (i != result.length - 1) {
        //         bufferedWriter.write("\n");
        //     }
        // }

        // bufferedWriter.newLine();

        // bufferedWriter.close();

        // scanner.close();
    }
}
