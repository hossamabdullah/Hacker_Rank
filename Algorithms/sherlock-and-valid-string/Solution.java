import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        char[] chars = s.toCharArray();
        Set<Character> oddCharacters = new HashSet<Character>();
        for(char temp: chars){
            if(oddCharacters.contains(temp))
                oddCharacters.remove(temp);
            else   
                oddCharacters.add(temp);
        }
        int l = oddCharacters.size();
        if(l==0 || l==1 || l==chars.length)
            return "YES";
        else
            return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
