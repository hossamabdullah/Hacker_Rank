import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, Cell queen, Cell[] obstacles) {
        int[][] map =new int[n][n];
        map[queen.getRow()][queen.getColumn()] = 0;
        
        //go up
        for(int i=queen.getRow(); i<n; i++){
            
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        Cell queen = new Cell(r_q-1, c_q-1);
        Cell[] obstacles = new Cell[k];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            Cell temp = new Cell();
            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                ///////////
                if(j==0){
                    temp.setRow(obstaclesItem - 1);
                }else{
                    temp.setCol(obstaclesItem - 1);
                }
            }
            obstacles[i] = temp;
        }

        ////////
        int result = queensAttack(n, k, queen, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

class Cell{
    private int row;
    private int column;

    public Cell(){

    }

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
    }

    public setRow(int row){
        this.row = row;
    }
    
    public getRow(){
        return this.row;
    }

    public setColumn(int column){
        this.column = column;
    }
    
    public getColumn(){
        return this.column;
    }
}