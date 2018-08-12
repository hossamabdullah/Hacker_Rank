import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution  {

    /**
     * @param n number of steps
     * @param s series of steps
     * 
     */
    static int countingValleys(int n, String s) {
        int seaLevel = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(seaLevel == 0 && s.charAt(i) == 'D')
                count++;
            if(s.charAt(i) == 'U')
                seaLevel++;
            else   
                seaLevel--;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
