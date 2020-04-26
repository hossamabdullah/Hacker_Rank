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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int entriesNum = sc.nextInt();
        String[] results = new String[entriesNum];

        for(int i=0; i<entriesNum/2; i++){
            int index = sc.nextInt();
            String temp  = sc.next();
            if(results[index] == null)
                results[index] = "";
            results[index] = results[index] + "- ";
        }

        for(int i=entriesNum/2; i<entriesNum; i++){
            int index = sc.nextInt();
            String data  = sc.next();
            if(results[index] == null)
                results[index] = "";
            results[index] = results[index] + data + " ";
        }

        for(int i=0; i<entriesNum; i++){
            if(results[i] != null)
                System.out.print(results[i]);
        }
        System.out.println();
    }
}
