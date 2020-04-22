import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(char[][] G, char[][] P, int R, int C, int r, int c) {
        for(int i=0; i<R-r; i++){
            for(int j=0; j<C-c; j++){
                boolean matchFound = true;
                for(int parentRow=i, childRow=0; parentRow<parentRow+r && childRow < r; parentRow++, childRow++){
                    for(int parentCol=j, childCol=0; parentCol<parentCol+c && childCol< c; parentCol++, childCol++){
                        if(G[parentRow][parentCol] != P[childRow][childCol]){
                            matchFound = false;
                            break;
                        }
                    }
                }
                if(matchFound)
                    return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            // String[] G = new String[R];
            char[][] GG = new char[R][C];            

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                GG[i] = GItem.toCharArray();
                
                // G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];
            char[][] PP = new char[r][c];
            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                PP[i] = PItem.toCharArray();
                // P[i] = PItem;
            }

            String result = gridSearch(GG, PP, R, C, r, c);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
