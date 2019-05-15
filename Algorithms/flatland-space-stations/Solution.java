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
        Arrays.sort(c);
        int maxDiff = 0;
        for(int i=1; i<c.length; i++){
            int diff = c[i] - c[i-1];
            if(diff > maxDiff){
                maxDiff = diff;
                System.out.println(maxDiff);
            }
        }

        boolean first= false;
        boolean last = false;
        if(c[0] != 0 && c[0] >= (maxDiff/2)){
            System.out.println("A");
            maxDiff = c[0];
            first= true;
        }
        if(c[c.length-1] != n-1 &&  n-1-c[c.length-1] >= (maxDiff/2) ){
            System.out.println("B");
            if(!first){
                last =true;
                maxDiff = n-1-c[c.length-1];
            }
            if(first && n-1-c[c.length-1] > maxDiff){
                first = false;
                last =true;
                maxDiff = n-1-c[c.length-1];
            }
        }
        if(last || first){
            return maxDiff;
        }
        System.out.println("C");
        return ((maxDiff)/2);
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


/*
test case
95 19
68 81 46 54 30 11 19 23 22 12 38 91 48 75 26 86 29 83 62



11

*/