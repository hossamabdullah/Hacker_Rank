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
/**
10
beabeefeab
 */
public class Solution {

    static List<Character> findDistinctCharacters(String s){
        List<Character> alphabets = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(!alphabets.contains(c))
                alphabets.add(c);
        }
        return alphabets;
    }

    static String removeOtherChars(String s, char a, char b){
        for(char c: s.toCharArray()){
            if(c != a &&  c != b)
                s = s.replaceAll(c+"", "");
        }
        return s;
    }

    static boolean isValid(String s){
        char oldChar = '1';
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == oldChar)
                return false;
            
            oldChar = s.charAt(i);
        }
        return true;
    }

    // Complete the alternate function below.
    static int alternate(String s) {
        List<Character> alphabets = findDistinctCharacters(s);
        int maxLength = 0;
        for(int i=0; i<alphabets.size()-1; i++){
            for(int j=i+1; j<alphabets.size(); j++){
                // System.out.println(alphabets.get(i)+", "+alphabets.get(j));
                String result = removeOtherChars(s, alphabets.get(i), alphabets.get(j));
                if(isValid(result) && result.length() >= maxLength){
                    maxLength = result.length();
                }
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
