import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        String plaindromeValue = "";
        char[] chars = s.toCharArray();
        int differences = 0; 
        for(int i=0; i<chars.length/2; i++){
            if(chars[i] != chars[chars.length-1-i])
                differences ++ ;
        }
        if(differences > k)
            return "-1";
        int extraCredit = k - differences;

        for(int i=0; i<chars.length/2; i++){
            if(chars[i] == chars[chars.length-1-i]){
                if(extraCredit > 0 && i==(chars.length-1-i)){
                    extraCredit --;
                    plaindromeValue = plaindromeValue + "9";    
                }else if(extraCredit > 1 && i!=(chars.length-1-i)){
                    extraCredit --;
                    extraCredit --;
                    plaindromeValue = plaindromeValue + "9";
                }else{
                    plaindromeValue = plaindromeValue + chars[i];
                }
            }else if(extraCredit > 0){
                differences--;
                extraCredit--;
                plaindromeValue = plaindromeValue + "9";
            }else{
                differences--;
                if(chars[i] >= chars[chars.length-1-i])
                    plaindromeValue = plaindromeValue + chars[i];
                else
                plaindromeValue = plaindromeValue + chars[chars.length-1-i];
            }
        }
        


        StringBuilder sb=new StringBuilder(plaindromeValue);  
        sb.reverse();  
        // if(n==1){
        //     if(k>=1)
        //         return "9";
        //     else
        //         return s;
        // }
        // if(n%2!=0)
        //     return plaindromeValue + s.charAt((n/2)+1) + sb.toString();
        // else 
            return plaindromeValue + sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
