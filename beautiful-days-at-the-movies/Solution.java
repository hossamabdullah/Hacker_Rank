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
            int temp = x;
            int numOfDigits = (int)(Math.log10(x)+1);
            int multiplier = (int)Math.pow(10, numOfDigits);
            // x = 123
            // x%10 = 3,  x/10=12
            // x%10 = 2,  x/10=1
            // x%10 - 1,  x/10=0
            int reverseX = 0;
            while(temp != 0){
                reverseX += multiplier* (temp%10);
                temp /= 10;
                multiplier /= 10;
                // System.out.println("reverseXxx : " + reverseX+", Temp : "+temp+", Mult: "+multiplier);
            }

            int diff = x - reverseX;
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
