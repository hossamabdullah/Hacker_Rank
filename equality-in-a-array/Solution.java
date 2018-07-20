import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> numOfOcc = new HashMap<>();
        int maxNumOfOcc = 0;

        for(int i=0; i<arr.length; i++){
            int currentNumOfOcc = 0;
            if(numOfOcc.containsKey(arr[i])){
                currentNumOfOcc = numOfOcc.get(arr[i]);
                currentNumOfOcc++;
                numOfOcc.remove(arr[i]);
                numOfOcc.put(arr[i], currentNumOfOcc);
            }else{
                numOfOcc.put(arr[i], 1);
            }

            if(currentNumOfOcc > maxNumOfOcc)
                maxNumOfOcc = currentNumOfOcc;
        }

        return arr.length - maxNumOfOcc;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
