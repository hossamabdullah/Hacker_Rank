import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static boolean isTriangle(int a, int b, int c){
        return ( (a+b>c) && (a+c>b) && (c+b>a) );
    }

    private static int priem(int a, int b, int c){
        return a+b+c;
    }

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        int longestPremiter = 0;
        int[] triangle = new int[3];
        for(int i=0; i<sticks.length-2; i++){
            for(int j=i+1; j<sticks.length-1; j++){
                for(int k=j+1; k<sticks.length; k++){
                    int a = sticks[i]; int b = sticks[j]; int c = sticks[k];
                    if(isTriangle(a, b, c) && priem(a, b, c) >longestPremiter){
                        longestPremiter = priem(a,b,c);
                        triangle[0] = a;
                        triangle[1] = b;
                        triangle[2] = c;
                    }
                }
            }
        }
            
        Arrays.sort(triangle);
        return triangle;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        if(result[0]==0 && result[1]==0 && result[2]==0){
            bufferedWriter.write("-1");
        }else
            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
