import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(int[][] grid) {

        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[i].length-1; j++){
                if(grid[i][j] > grid[i-1][j] &&
                grid[i][j] > grid[i+1][j] &&
                grid[i][j] > grid[i][j-1] &&
                grid[i][j] > grid[i][j+1])
                    grid[i][j] = -1;
            }
        }

        String[] result = new String[grid.length];
        for(int i=0; i<grid.length; i++){
            result[i] = "";
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == -1)
                    result[i] += "X";
                else
                    result[i] += grid[i][j];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            int index = n-1;
            while(temp != 0){
                grid[i][index] = temp % 10;
                temp  = temp / 10;
                index--;
            }
        }

        String[] result = cavityMap(grid);
        
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
