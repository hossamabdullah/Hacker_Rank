import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(char[][] grid) {
        String[] result = new String[grid.length];
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[i].length-1; j++){
                if(grid[i][j] > grid[i-1][j] && grid[i][j] > grid[i+1][j]
                && grid[i][j] > grid[i][j-1] && grid[i][j] > grid[i][j+1]){
                    grid[i][j] = 'X';
                }
            }
            result[i] =  new String(grid[i]);
        }
        result[0] =  new String(grid[0]);
        result[grid.length-1] =  new String(grid[grid.length-1]);
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        char[][] gridd  = new char[n][n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            char[] gridItemChars = gridItem.toCharArray();
            gridd[i] = gridItemChars;
        }

        String[] result = cavityMap(gridd);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
