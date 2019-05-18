import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String bigIsGr(String w){
        String prev = "";
        String restOfWord = w.substring(1);
        if(w.length() != 1){
            prev = bigIsGr(restOfWord);
        }

        
        char s = w.charAt(0);
        if(w.length() == 1){
            //only one character in w, lets just return it
            return new String(s);
        }else{
            //char s     String prev
            if(prev.compareTo(restOfWord) > 0){
                return s + prev;
            }else{
                char[] prevC = prev.toCharArray();
                for(int i=0; i<prevC.length; i++){
                    
                }
            }
        }
        
        return null;
    }

    
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] c = w.toCharArray();
        boolean descSorted = true;
        for(int i=0; i<c.length-1; i++){
            if(c[i] < c[i+1])
                descSorted = false;
        }
        if(descSorted)
            return "no answer";

        List<Character> n = new ArrayList<Character>();
        n.add(c[c.length-1]);

        int foundIndex = 1000;
        for(int i=c.length-2; i>=0; i--){
            boolean biggerThanAll = true;
            if(foundIndex != 1000){
                System.out.println(c[i]);
                // n.add(0, c[i]);
            }
            for(int j=0; j<n.size(); j++){
                if(c[i] < n.get(j)){
                    biggerThanAll = false;
                    foundIndex = j;
                }
            }
            if(biggerThanAll){
                n.add(c[i]);
            }else{
                char temp = n.get(foundIndex);
                n.remove(foundIndex);
                n.add(foundIndex, c[i]);
                n.add(0, temp);
                break;
            }
        }

        System.out.println(n.size());
        StringBuilder sb = new StringBuilder();
        for (Character ch : n) { 
            sb.append(ch); 
        } 
        String result = sb.toString();
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = bigIsGr(w);

            // bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
