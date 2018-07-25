import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
/**
 * 
 * 1 1
 * 1 2
 * 2 1
 * 2 2
 * 
 */
    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        // int[] data = new int[(int)Math.pow(n,2)/2];
        Set<Integer> data = new HashSet<>();
        for(int i=0; i<(int)Math.pow(n,2)/2; i++){
            int temp = 0;
            String x = Integer.toBinaryString(i);
            while(x.length()<n-1){
                x = "0"+x;
            }
            System.out.print(x);
            for(int k=x.length()-1; k>=0 ;k--){
                if(x.charAt(k) == '0')
                    temp = temp  + a;
                else
                    temp = temp + b;
            }
            System.out.println(", value= "+temp);
            if(temp != 0)
                data.add(temp);
        }

        int[] sol = new int[data.size()];
        int index= 0;
        for(Integer i: data){
            sol[index++] = i;
        }
        return sol;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
