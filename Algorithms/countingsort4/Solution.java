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
        for(List<String> occurence: arr){
            if(reduceToDashCount!=0){
                occurence.remove(1);
                occurence.add("-");
                reduceToDashCount--;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        int currentIndex = 0;
        int length = 0;
        while(length!=arr.size()){
            for(List<String> occurence: arr){
                if(occurence.get(0).equals(currentIndex+"")){
                    // System.out.println(occurence.get(0)+","+currentIndex+","+occurence.get(1)+","+sb.toString());
                    sb.append(occurence.get(1));
                    sb.append(" ");
                    length++;
                }
            }

            currentIndex++;
        }

        System.out.println(sb.toString());
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
