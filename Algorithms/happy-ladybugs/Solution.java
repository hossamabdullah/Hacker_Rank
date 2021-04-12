import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        char[] cellsArray = b.toCharArray();
        List<Character> cells = new ArrayList<>();
        for(char c : cellsArray){
            cells.add(c);
        }

        boolean isLadyBugExist = cells.stream()
                            .filter(c -> c != '_')
                            .findAny()
                            .isPresent();
        System.out.println(isLadyBugExist);
        if(!(isLadyBugExist))return "NO";
        System.out.println(!(isLadyBugExist));

        Map<Character, Long> counts = cells.stream()
                            .filter(c -> c != '_')
                            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        boolean isCharacterOccuredOnce = counts.values().stream().filter(c -> c==1).findAny().isPresent();
        if(isCharacterOccuredOnce) return "NO";

        boolean isEmptyCellsExist = cells.stream().filter(c -> c =='_').findAny().isPresent();
        if(!isEmptyCellsExist){
            boolean res = true;
            for(int i=1; i<cells.size()-1; i++){
                if(cells.get(i) != cells.get(i+1) && cells.get(i) != cells.get(i-1))
                    res = false;
            }
            if(!res)
                return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
