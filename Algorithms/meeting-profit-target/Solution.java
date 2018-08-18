import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numOfIter = sc.nextInt();
        for(int t=0; t<numOfIter; t++){
            int days = sc.nextInt();
            long remaining = 0;
            for(int d=0; d<days; d++){
                long actual = sc.nextLong();
                long estimated = sc.nextLong();
                remaining = estimated + remaining - actual;
                if(remaining <= 0)
                    remaining = 0;

            }
            if(remaining == 0)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
