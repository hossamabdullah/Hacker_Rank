import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gameWithCells function below.
     */
    static int gameWithCells(int n, int m) {
        
        int fourBlocksSuppliers = (n/2) * (m/2);
        // System.out.println(n/2 + "*" + m/2 + ":" + fourBlocksSuppliers);
        int remainingBlocks = (n%2)*m + (m%2)*n;
        // System.out.println(remainingBlocks);
        if(m%2!=0 && n%2!=0)
            remainingBlocks -= 1;
        int remainingBlocksSuppliers = remainingBlocks / 2 + remainingBlocks % 2;
        // System.out.println(remainingBlocksSuppliers);
        return fourBlocksSuppliers + remainingBlocksSuppliers;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());
        int result = gameWithCells(n, m);
        System.out.println(result);
    }
}