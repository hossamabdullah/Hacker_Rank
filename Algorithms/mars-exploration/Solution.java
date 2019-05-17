import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final char first = 'S';
    private static final char second = 'O';
    private static final char third = 'S';

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        char[] sChars = s.toCharArray();
        int count = 0;
        System.out.println(sChars.length);
        for(int i=0; i<sChars.length-2; i+=3){
            if(sChars[i] != first)
                count++;
            if(sChars[i+1] != second)
                count++;
            if(sChars[i+2] != third)
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
