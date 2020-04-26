import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
        int reduceToDashCount = arr.size()/2;
        int max = 0;
        for(List<String> occurence: arr){
            if(Integer.parseInt(occurence.get(0)) > max)
                max = Integer.parseInt(occurence.get(0));
            if(reduceToDashCount!=0){
                occurence.remove(1);
                occurence.add("-");
                reduceToDashCount--;
            }
        }
        // System.out.println(max);
        String[] output = new String[max+1];
        for(List<String> occurence: arr){
            int currentIndex = Integer.parseInt(occurence.get(0));
            if(output[currentIndex] != null)
                output[currentIndex] = output[currentIndex] + occurence.get(1) + " ";
            else
                output[currentIndex] = occurence.get(1) + " ";
        }

        for(String o: output){
            if(o!=null)
            System.out.print(o);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}
