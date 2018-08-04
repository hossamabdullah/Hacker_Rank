import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if(m == 0)
            return (data[h]+" o' clock");
            
        if(m <= 30){
            String connectionWord = desc[m];
            connectionWord += " past ";
            return data[m] + connectionWord + data[h];
        }else{
            m = 60 - m;
            h = h + 1;
            String connectionWord = desc[m];
            connectionWord += " to ";
            return data[m] + connectionWord + data[h];
        }
    }

    private static final String[] desc = {
        "",
        " minute",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        "",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        " minutes",
        "",
    };

    private static final String[] data ={
        "temp because of zero index",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "quarter",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "twenty",
        "twenty one",
        "twenty two",
        "twenty three",
        "twenty four",
        "twenty five",
        "twenty six", 
        "twenty seven",
        "twenty eight",
        "twenty nine",
        "half"
    };
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String result = timeInWords(h, m);

        System.out.println(result);

        scanner.close();
    }
}
