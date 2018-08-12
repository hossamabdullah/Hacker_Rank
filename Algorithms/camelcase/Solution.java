import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String s = scanner.nextLine();
        int count = 1;
        for(int i=0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i)))
                count++;
        }
        System.out.println(count);
    }
}