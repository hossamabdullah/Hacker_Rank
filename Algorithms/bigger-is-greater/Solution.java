import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static char[] swap(char[] ar, int firstIndex, int secondIndex){
        int temp = ar[firstIndex];
        ar[firstIndex] = ar[secondIndex];
        ar[secondIndex] = temp;
        return ar;
    }

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] c = w.toCharArray();
        for(int i=c.length-1; i>=0; i--){
            System.out.print(c[i]);
            for(int j=i+1; j<c.length; j++){
                System.out.print(c[j]);
            }
            System.out.println();
        }
        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
