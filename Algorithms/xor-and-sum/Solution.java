import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    private final static Integer SUMMATION_END = 314159;
    /*
     * Complete the 'xorAndSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static BigInteger xorAndSum(String aStr, String bStr, int i) {
        BigInteger aInt = new BigInteger(aStr, 2);
        BigInteger bInt = new BigInteger(bStr, 2);
        
        if(i > SUMMATION_END){
            return new BigInteger("0");
        }
        
        i = i + 1;
        BigInteger previousSum = xorAndSum(aStr, bStr, i);
        BigInteger currentVal = aInt.xor(bInt.shiftLeft(i));
        return previousSum.add(currentVal);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        BigInteger result = Result.xorAndSum(a, b, 0);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
