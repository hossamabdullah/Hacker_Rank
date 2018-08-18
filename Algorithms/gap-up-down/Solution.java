import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {
        int gapUpCount = 0;
        int gapDownCount = 0;
        for (int i = 1; i < low.size(); i++) {
            if (low.get(i) > close.get(i - 1))
                gapUpCount++;
            if (high.get(i) < close.get(i - 1))
                gapDownCount++;
        }
        System.out.println(gapUpCount+" "+gapDownCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] lowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> low = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int lowItem = Integer.parseInt(lowItems[i]);
            low.add(lowItem);
        }

        String[] highItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> high = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int highItem = Integer.parseInt(highItems[i]);
            high.add(highItem);
        }

        String[] closeItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> close = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int closeItem = Integer.parseInt(closeItems[i]);
            close.add(closeItem);
        }

        solve(low, high, close);

        bufferedReader.close();
    }
}
