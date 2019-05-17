import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[] result = new int[2];
        for(int i=0; i<topic.length-1; i++){
            int teamI = Integer.parseInt(topic[i], 2);

            for(int j=i+1; j<topic.length; j++){
                int teamJ = Integer.parseInt(topic[j], 2);

                // System.out.println((teamI | teamJ));
                int temp = Integer.bitCount((teamI | teamJ));

                if(temp == result[0]){
                    result[1]++;
                }
                if(temp  > result[0]){
                    result[0] = temp;
                    result[1] = 1;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
