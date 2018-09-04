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
    public static void reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;
    
        while( left < right ) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
    
            // move the left and right index pointers in toward the center
            left++;
            right--;
        }
    }
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        reverse(alice);
        int fullLength = scores.length + alice.length;
        Rank[] rankings = new Rank[fullLength];
        
        //Merge concatenation
        int si = 0;//score index
        int ai = 0;//alice index
        for(int i=0; i<fullLength; i++){
            Rank temp = null;
            if(si == scores.length){
                temp = new Rank(alice[ai], true);
                ai++;
            }else if(ai == alice.length){
                temp = new Rank(scores[si], false);
                si++;
            }else if(scores[si] > alice[ai]){
                temp = new Rank(scores[si], false);
                si++;
            }else{
                temp = new Rank(alice[ai], true);
                ai++;
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
        
        int[] answer = new int[alice.length];
        int answerIndex =  alice.length-1;
        for(int i=0; i<rankings.length; i++){
            if(rankings[i].isAlice){
                answer[answerIndex] = rankings[i].rank;
                answerIndex--;
            }
        }
        return answer;
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

        // for(int i=0; i<result.length; i++){
        //     System.out.println(result[i]);
        // }
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
