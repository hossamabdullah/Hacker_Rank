import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        char a = 'a';
        char[] chars = s.toCharArray();
        Set<Integer> availableCombinations = new HashSet<>();
        
        char previousChar = '0'; //0 as a first token
        int sum = 0;
        for(char tempChar: chars){
            if(previousChar == tempChar){
                sum += tempChar - a + 1;
            }else{
                previousChar = tempChar;
                sum = tempChar - a + 1;
            }
            // System.out.println(tempChar +", "+previousChar+", "+sum);
            if(sum != 0){
                availableCombinations.add(sum);
            }
        }

        // for(Integer ss: availableCombinations){
        //     System.out.println(ss);
        // }

        String[] results = new String[queries.length];
        int index =0;
        for(int q : queries){
            if(availableCombinations.contains(q)){
                results[index] = "Yes";
            }else{
                results[index] = "No";
            }
            index++;
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
