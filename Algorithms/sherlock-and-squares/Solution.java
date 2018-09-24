import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int count = 0;
        for(Long i: squaredIntegers){
            if(i > b)
                break;
            if(i >= a && i <= b){
                count++;
            }
        }
        return count;
    }
    

    private static long[] squaredIntegers = new long[31624];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        for(int i=1; i<31624; i++){
            long square = (long)Math.pow(i, 2);
            squaredIntegers[i-1] = square;
        }
        // for(int i=31624; i>=1; i--){
        //     System.out.println(squaredIntegers[i-1]);
        // }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
