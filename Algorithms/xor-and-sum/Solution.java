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
    private final static Long MOD_VAL = new Long("1000000007");
    /*
     * Complete the 'xorAndSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static Long xorAndSum(Long aInt, Long bInt, int i) {
        if(i > SUMMATION_END){
            return 0l;
        }
        
        Long previousSum = xorAndSum(aInt, bInt, i+1);
        
        Long currentVal = aInt ^ (bInt << i);
        currentVal =  currentVal % MOD_VAL;
                                        
        Long newVal = previousSum + currentVal;
        newVal = newVal % MOD_VAL;
        
        return newVal;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        Long result = Result.xorAndSum(Long.parseLong(a, 2), Long.parseLong(b, 2), 0);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
