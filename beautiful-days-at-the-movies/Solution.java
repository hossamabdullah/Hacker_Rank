import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    /**
     * 
     * @param i start of range
     * @param j end of range
     * @param k number for beautifulDays to be divisible by it
     */
    static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        for(int x=i; x<=j; x++){
            String num = x+"";
            String reversed = "";
            for(int c=num.length()-1; c>=0; c--){
                reversed = reversed+num.charAt(c);
            }
            int reversedNum = Integer.parseInt(reversed);

            System.out.println("rev: "+reversedNum+", num: "+x);
            int diff = x - reversedNum;
            if(diff < 0)
                diff *= -1;
            
            if(diff % k == 0)
                counter++;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
