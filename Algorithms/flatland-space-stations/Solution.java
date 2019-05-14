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
        int[] spaces = new int[n];
        for(int i=0; i<c.length; i++){
            spaces[c[i]] = 1;
        }
        int longest = 0;
        int chain = 0;
        boolean firstOneFlag = true;
        boolean lastOneFlag = false;
        if(spaces[0] == 1)
            firstOneFlag = false;
        for(int i=0; i<n; i++){
           if(spaces[i] == 0){
               chain++;
           }else{
               if(((chain > longest) && longest != 0)){
                    firstOneFlag = false;
               }
               if(chain > longest){
                    longest= chain;   
                }
               chain = 0;
           }
        }
        if(chain > longest){
            System.out.println("In");
            longest= chain;
            lastOneFlag = true;
        }
        if(firstOneFlag || lastOneFlag){
            System.out.println("Im in");
            return longest;
        }
        System.out.println("lets print longest: "+longest);
        return (longest +1)/2;
    }

    // 00000100
    // 1000001001
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