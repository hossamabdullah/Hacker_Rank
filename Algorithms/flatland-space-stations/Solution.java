import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        if(n == c.length)
            return 0;

        int[] data = new int[n];
        int[] distance = new int[n];

        for(int i=0; i<c.length; i++){
            data[c[i]] = 1;
        }

        int maxDistance = 0;
        for(int i=0; i<n; i++){
            if(data[i] == 1)
                maxDistance = 0;
            else{
                distance[i] = ++maxDistance;
            }                
        }

        maxDistance = 0;
        for(int i=n-1; i>=0; i--){
            if(data[i] == 1){
                maxDistance = 0;
            }else{
                maxDistance++;
                if(maxDistance < distance[i]){
                    distance[i] = maxDistance;
                }
            }
        }

        maxDistance = 0;
        for(int i=0; i<n; i++){
            if(distance[i] > maxDistance){
                maxDistance = distance[i];
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.print(data[i]);
        // }
        return maxDistance;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
