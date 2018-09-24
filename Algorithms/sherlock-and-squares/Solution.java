import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        return 0;
    }
    

    private static Set<Double> squaredIntegers = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        double square = 0;
        int i = 1;
        while(square < 1000000000){
            square = Math.pow(i, 2);
            squaredIntegers.add(square);
            i++;
        }
        System.out.println(Math.pow(i-1, 2));
        System.out.println(squaredIntegers.size());

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
