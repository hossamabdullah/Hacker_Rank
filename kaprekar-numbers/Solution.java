import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javafx.stage.PopupWindow;

public class Solution {

    static void kaprekarNumbers(int p, int q) {
        for(int i=p; i<=q; i++){
            double result = Math.pow(i, 2);
            int length = String.valueOf(i).length();
            double separator = Math.pow(10, length);
            int sum = 0;
            while(result!=0){
                sum += result % separator;
                result /= separator;
            }
            if(sum == i){
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
