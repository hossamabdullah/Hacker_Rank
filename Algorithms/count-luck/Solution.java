import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countLuck function below.
    static int countLuck(char[][] matrix, int startRow, int startCol, int k) {
        matrix[startRow][startCol] = '.';
        int res =  countLuck(matrix, startRow, startCol, true);
        return res;
    }

    static boolean isValidNode(char[][] matrix, int row, int col){
        if(
            currentCol == -1
            || currentRow == -1
            || currentRow >= matrix.length
            || currentCol >= matrix[currentRow].length
            || matrix[currentRow][currentCol] == 'X'
            || matrix[currentRow][currentCol] == 'M'
            || matrix[currentRow][currentCol] == 'P')
            return true;
        else 
            return false;
    }

    static int countLuck(char[][] matrix, int currentRow, int currentCol, boolean firstTime){
        if(isValidNode(matrix,currentRow, currentCol)) return 0;
        if(matrix[currentRow][currentCol] == '*')  return 1;
        matrix[currentRow][currentCol] = 'P'; //Passed
        
        System.out.println(matrix[currentRow][currentCol]);
        
        int a = countLuck(matrix, currentRow, currentCol+1, false);
        int b = countLuck(matrix, currentRow, currentCol-1, false);
        int c = countLuck(matrix, currentRow+1, currentCol, false);
        int d = countLuck(matrix, currentRow-1, currentCol, false);

        // if(a +b + c+ d ==0) return -1;
        if(a + b + c + d== 1)  return 0;
        else return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];
            char[][] data = new char[n][m];
            int startRow = 0;
            int startCol = 0;
            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
                
                if(matrixItem.contains("M")){
                    startRow = i;
                    startCol = matrixItem.indexOf("M");
                }
                data[i] = matrixItem.toCharArray();
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            
            
            int result = countLuck(data, startRow, startCol, k);

            bufferedWriter.write(result+"");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
