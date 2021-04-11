import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        char[] data = s.toCharArray();
        Set<Character> dataDuplicateFree = convertFromArrayToSet(data);
        if(dataDuplicateFree.size() == data.length)
            return 0;
        else
            return 2;
    }

    private static Set<Character> convertFromArrayToSet(char[] data){
        Set<Character> dataDuplicateFree = new HashSet<>();
        for(int i=0; i<data.length; i++){
            dataDuplicateFree.add(data[i]);
        }
        return dataDuplicateFree;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
