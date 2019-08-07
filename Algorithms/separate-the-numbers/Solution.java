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
        BigInteger minStart = null;
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

                BigInteger prev = new BigInteger(prevString);
                if(prevString.matches("9+")){
                // if(((prev.add(BigInteger.ONE)).mod(BigInteger.TEN).equals(BigInteger.ZERO))){
                    
                    if((i + range + 1) > length){
                        seqFound = false;
                        break;
                    }
                    range++;
                    rangeIncreased = true;
                }
                String currentString = s.substring(i, i+range);
                if(currentString.charAt(0) == '0'){
                    seqFound = false;
                    break;
                }

                BigInteger current = new BigInteger(currentString);
                // System.out.println(current+" - "+prev+" = "+current.subtract(prev));
                // System.out.println(current.subtract(prev) != BigInteger.ONE);
                if(!(current.subtract(prev).equals(BigInteger.ONE))){
                    seqFound = false;
                    break;
                }
            }
            if(seqFound){
                if(rangeIncreased)
                    minStart =new BigInteger(s.substring(0, range-1));
                else
                    minStart = new BigInteger(s.substring(0, range));
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
