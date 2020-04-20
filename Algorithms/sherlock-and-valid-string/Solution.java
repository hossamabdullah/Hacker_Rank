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
        Map<Character, Integer> charsCount = new HashMap<>();

        for(char temp: chars){
            if(charsCount.containsKey(temp))
                charsCount.put(temp, charsCount.get(temp)+1);
            else
                charsCount.put(temp, 1);
        }
        
        Map<Integer, Integer> countCount = new HashMap<>();
        for(char key: charsCount.keySet()){
            if(countCount.containsKey(charsCount.get(key)))
                countCount.put(charsCount.get(key), (countCount.get(charsCount.get(key))+1));
            else
            countCount.put(charsCount.get(key), 1);
        }

        for(int a :  countCount.keySet()){
            System.out.println(a +", "+ countCount.get(a));
        }
        

        if(countCount.size() == 1)
            return "YES";

        if(countCount.size() == 2){
            Integer key1 = (Integer)countCount.keySet().toArray()[0];
            Integer key2 = (Integer)countCount.keySet().toArray()[1];
            int val1 = countCount.get(key1);
            int val2 = countCount.get(key2);
            if( ((val1 == 1 || val2 == 1) && (key2 - key1 == 1  || key2 - key1 == -1)) || ((val1 == 1 && key1 ==1 )|| (val2 == 1 && key2 ==1)))
                return "YES";
        }   

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
