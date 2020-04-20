import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int maxLength = 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for(int a= 0 ; a < s1Chars.length; a++){
            int length = 0;
            for(int b = 0; b < s2Chars.length; b++){
                if(s1Chars[a] == s2Chars[b]){
                    length++;
                    for(int aa=a+1, bb=b+1; aa<s1Chars.length && bb<s2Chars.length; aa++, bb++){
                        if(s1Chars[aa] == s2Chars[bb]){
                            length++;
                        }
                    }
                    if(length > maxLength)
                        maxLength = length;
                }
            }
        }

        System.out.println(maxLength);
        return (s1Chars.length - maxLength + s2Chars.length - maxLength);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
