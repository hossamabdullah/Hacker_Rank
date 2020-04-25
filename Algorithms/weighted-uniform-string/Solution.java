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
        String[] results = new String[queries.length];
        int index = 0;
        for(int i=0; i<queries.length; i++){
            results[index] = "No";
            char[] cs = s.toCharArray();
            int sum = 0;
            char currentChar = '0';
            for(int j=0; j<cs.length; j++){
                if((cs[j] - a + 1) > queries[i])
                    break;
                
                if(cs[j] != currentChar){
                    currentChar = cs[j];
                    sum = 0;
                    sum += (cs[j] - a + 1);
                }else{
                    sum += (cs[j] - a + 1);
                }

                if(sum == queries[i]){
                    results[index] = "Yes";
                    break;
                }
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
