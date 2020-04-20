import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int makingAnagrams(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        int[] char1Occs = new int[26];
        int[] char2Occs = new int[26];
        for(int i= 0; i< s1Chars.length; i++){
            char1Occs[s1Chars[i] - 'a']++;
        }

        for(int i= 0; i< s2Chars.length; i++){
            char2Occs[s2Chars[i] - 'a']++;
        }

        int difference = 0;
        for(int i=0; i<26; i++){
            difference += Math.abs(char1Occs[i] - char2Occs[i]);
        }

        return difference;
    }

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length() % 2 !=0)
            return -1;
        else 
            return makingAnagrams(s.substring(0, s.length()/2), s.substring(s.length()/2, s.length()))/2;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
