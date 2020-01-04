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

    // Complete the alternate function below.
    static int alternate(String s) {
        List<Character> alphabets = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(!alphabets.contains(c))
                alphabets.add(c);
        }

        int maxLength = 0;
        for(int i=0; i<alphabets.size()-1; i++){
            for(int j=i+1; j<alphabets.size(); j++){
                int tempLength = s.length() - (s.replaceAll(alphabets.get(i)+"", "").replaceAll(alphabets.get(j)+"", "").length());
                if(tempLength > maxLength)
                    maxLength = tempLength;
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
