import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        // System.out.println(s);
        int length = s.length();
        int halfLength = length/2;

        int range = 1;
        Integer minStart = null;
        while(range <= halfLength){
            boolean seqFound = true;
            boolean rangeIncreased = false;

            for(int i=range; (i+range)<=length; i+=range){
                // System.out.println(i +", "+ range);
                String prevString = s.substring(i-range, i);
                if(prevString.charAt(0) == '0'){
                    seqFound = false;
                    break;
                }
                int prev = Integer.parseInt(prevString);
                if((prev+1) % 10 == 0){
                    range++;
                    rangeIncreased = true;
                }
                String currentString = s.substring(i, i+range);
                if(currentString.charAt(0) == '0'){
                    seqFound = false;
                    break;
                }
                int current = Integer.parseInt(currentString);
                // System.out.println(current+" - "+prev);
                if(current - prev != 1){
                    seqFound = false;
                    break;
                }
            }
            if(seqFound){
                if(rangeIncreased)
                    minStart = Integer.parseInt(s.substring(0, range-1));
                else
                    minStart = Integer.parseInt(s.substring(0, range));
                break;
            }else{
                if(!rangeIncreased)
                    range++;
            }
        }


        if(minStart == null){
            System.out.println("NO");
        }else{
            System.out.println("YES "+minStart);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
