import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";

        boolean numbersFlag = false, lowerCaseFlag = false, upperCaseFlag = false, specialCharactersFlag= false;
        int count = 4;
        for(int i=0; i<password.length(); i++){
            String currentChar = password.charAt(i)+"";
            if(!numbersFlag && numbers.contains(currentChar)){
                numbersFlag =true;
                count --;
            }else if(!lowerCaseFlag && lowerCase.contains(currentChar)){
                lowerCaseFlag =true;
                count --;
            }else if(!upperCaseFlag && upperCase.contains(currentChar)){
                upperCaseFlag=true;
                count --;
            }else if(!specialCharactersFlag && specialCharacters.contains(currentChar)){
                specialCharactersFlag = true;
                count --;
            }
            if(numbersFlag && lowerCaseFlag && upperCaseFlag && specialCharactersFlag)
                break;
        }
        
        if(n+count < 6){
            int temp = n + count;
            count += 6 - (temp);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
