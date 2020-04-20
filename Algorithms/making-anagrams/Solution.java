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
        System.out.println(s1);
        System.out.println(s2);
        int maxLength = 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        String choosed = "";
        for(int a= 0 ; a < s1Chars.length; a++){
            for(int b = 0; b < s2Chars.length; b++){
                int length = 0;
                if(s1Chars[a] == s2Chars[b]){
                    length++;
                    String word=  s1Chars[a] + "";
                    for(int aa=a+1, bb=b+1; (aa<s1Chars.length && bb<s2Chars.length && s1Chars[aa] == s2Chars[bb]); aa++, bb++){
                        length++;
                        word = word + s1Chars[aa];
                    }
                    if(length > maxLength){
                        maxLength = length;
                        choosed = word;
                    }
                }
            }
        }

        System.out.println(maxLength);
        System.out.println(choosed);
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
