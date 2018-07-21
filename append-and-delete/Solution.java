import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int sLength = s.length();
        int tLength = t.length();

        int max = 0;
        if(sLength > tLength)
            max = sLength;
        else   
            max = tLength;

        int numOfSimilarties = 0;
        for(int i=0; i<sLength; i++){
            if(i == t.length())
                break;
            if(s.charAt(i) == t.charAt(i))
                numOfSimilarties++;
        }

        int sDiff = sLength - numOfSimilarties;
        int tDiff = tLength - numOfSimilarties;

        if(k < (tDiff + sDiff))
            return "No";
        if(k == (tDiff + sDiff))
            return "Yes";

        k -= (sDiff + tDiff);

        if(k >= (2*numOfSimilarties))
            return "Yes";

        if(k % 2 ==0)
            return "Yes";
        else
            return "No";
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
