import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    /*
     * Complete the primeCount function below.
     */
    static int primeCount(long n) {
        BigInteger result = BigInteger.ONE;
        int count = 0;
        for(int i=0; i<primes.length; i++){
            result = result.multiply(new BigInteger(primes[i]+""));
            // result *= primes[i];
            if(result.compareTo(new BigInteger(n+"")) <= 0)
                count++;
            else
                break;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(scanner.nextLine().trim());

            int result = primeCount(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
