import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static int[][] cavityMap(int[][] grid) {
        for(int i=1; i<grid.length-1; i++){
            String line = "";
            for(int j=1; j<grid[i].length-1; j++){
                int key = grid[i][j];
                if(key > grid[i-1][j] && key > grid[i+1][j]
                && key > grid[i][j-1] && key > grid[i][j+1]){
                    grid[i][j] = -1;
                }
            }
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            // System.out.println(temp+"");
            // System.out.println(temp / (int)Math.pow(10, n-1));
            while(temp / (int)Math.pow(10, n-1) == 0){
                temp *= 10;
                temp +=  scanner.nextInt();
                // System.out.println("InIF " + temp+"");
            }
            int index = n-1;
            while(temp != 0){
                grid[i][index] = temp % 10;
                temp  = temp / 10;
                index--;
            }
        }

        int[][] result = cavityMap(grid);
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                int item = result[i][j];
                if(item == -1)
                    System.out.print("X");
                else
                    System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
