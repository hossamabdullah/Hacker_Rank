import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countLuck function below.
    static boolean countLuck(char[][] matrix, int startRow, int startCol, int k) {
        matrix[startRow][startCol] = '.';
        int res =  countLuck(matrix, startRow, startCol, true);
        if(res-1 == k) return true;
        else           return false;
    }

    static int isValidNode(char[][] matrix, int currentRow, int currentCol){
        if(
            currentCol == -1
            || currentRow == -1
            || currentRow >= matrix.length
            || currentCol >= matrix[currentRow].length
            || matrix[currentRow][currentCol] == 'X'
            || matrix[currentRow][currentCol] == 'M'
            || matrix[currentRow][currentCol] == 'P')
            return 0;
        else 
            return 1;
    }

    static int countLuck(char[][] matrix, int currentRow, int currentCol, boolean firstTime){
        if(isValidNode(matrix,currentRow, currentCol)==0) return 0;
        if(matrix[currentRow][currentCol] == '*')  return 1;
        matrix[currentRow][currentCol] = 'P'; //Passed
        
        //System.out.println(currentRow+", "+currentCol);

        int u = isValidNode(matrix, currentRow , currentCol+1);
        int d = isValidNode(matrix, currentRow , currentCol-1);
        int n = isValidNode(matrix, currentRow+1 , currentCol);
        int p = isValidNode(matrix, currentRow-1 , currentCol);

        int A=0, B=0, C=0, D = 0;
        if(u == 1) A = countLuck(matrix, currentRow, currentCol+1, false);
        if(d == 1) B = countLuck(matrix, currentRow, currentCol-1, false);
        if(n == 1) C = countLuck(matrix, currentRow+1, currentCol, false);
        if(p == 1) D = countLuck(matrix, currentRow-1, currentCol, false);

        int inc = 1;
        if(u+d+n+p == 1) inc=0;

        if(A > 0) return A+inc;
        if(B > 0) return B+inc;
        if(C > 0) return C+inc;
        if(D > 0) return D+inc;

        return 0;
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

            
            
            boolean result = countLuck(data, startRow, startCol, k);
            String res = "";
            if(result)  res= "Impressed";
            else        res= "Oops!";
            bufferedWriter.write(res+"");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
