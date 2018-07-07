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
        int max = 0;
        for(int i=0; i<a.length; i++){
            int above = 1;
            int below = 1;
            for(int j=0; j<a.length; j++){
                if(i == j)
                    continue;
                if(a[j] == a[i]){
                    above++;
                    below++;
                }else if(a[j] == (a[i]+1)){
                    above++;
                }else if(a[j] == (a[i]-1)){
                    below++;
                }   
            }

            if(above > max)
                max = above;
            if(below > max)
                max = below;
        }
        return max;
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
