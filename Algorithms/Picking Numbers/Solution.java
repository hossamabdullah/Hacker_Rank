import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * 
     * @param a list of elements in the array1
     */
    static int pickingNumbers(int[] a) {
        int[] count = new int[100];
        int max = 0;
        int maxInterval = 0;

        for(int i=0; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
            
            count[a[i]]++;
        }

        for(int i=0; i<max; i++){
            int temp = count[i] + count[i+1];
            if(temp > maxInterval)
                maxInterval = temp;
        }

        return maxInterval;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
