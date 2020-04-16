import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        char[] data = arr[0].toCharArray();
        for(int i=0; i<data.length-1; i++){
            for(int j=i+1; j<data.length; j++){
                if(data[i] == data[j])
                    data[j] = '0';
            }
        }
        
        for(int i=1; i<arr.length; i++){
            for(int o=0; o<data.length; o++){
                boolean isFoundFlag = false;

                for(char temp: arr[i].toCharArray()){
                    if(data[o] == temp){
                        isFoundFlag = true;
                        break;
                    }
                }

                if(!isFoundFlag){
                    data[o] = '0';
                }
            }
        }

        int count = 0;
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
            if(data[i] != '0')
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
