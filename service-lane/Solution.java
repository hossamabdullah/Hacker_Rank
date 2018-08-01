import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] serviceLane(int[] widths, int[][] t, int tLength) {
        int[] result = new int[tLength];
        for(int i=0; i<tLength; i++){
            int min = 1000000;
            for(int j=t[i][0]; j<=t[i][1]; j++){
                if(widths[j] < min){
                    min = widths[j];
                }
                if(min == 1)
                    break;
            }
            result[i] = min;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int testCasesNum = sc.nextInt();

        int[] widths = new int[length];
        for(int i=0; i<length; i++){
            widths[i] = sc.nextInt();
        }

        int[][] testCases = new int[testCasesNum][2];
        for(int i=0; i<testCasesNum; i++){
            testCases[i][0] = sc.nextInt();
            testCases[i][1] = sc.nextInt();
        }

        int[] result = serviceLane(widths, testCases, testCasesNum);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
