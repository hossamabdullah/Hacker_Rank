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
        return (int) (Math.ceil(n/2.0) * Math.ceil(m/2.0));
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
