import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = alph.toCharArray();
        char[] upperAlphabet = alph.toUpperCase().toCharArray();
        Map<Character, Character> newCharacters = new HashMap<>();

        for(int i=0; i<alphabet.length; i++){
            int newCharIndex = i+k;
            newCharIndex = newCharIndex % alphabet.length;
            newCharacters.put(alphabet[i], alphabet[newCharIndex]);
        }

        for(int i=0; i<upperAlphabet.length; i++){
            int newCharIndex = i+k;
            newCharIndex = newCharIndex % upperAlphabet.length;
            newCharacters.put(upperAlphabet[i], upperAlphabet[newCharIndex]);
        }

        newCharacters.put('-', '-');

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(newCharacters.get(c));
        }

        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
