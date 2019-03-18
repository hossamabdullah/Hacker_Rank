import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        // List<BigInteger> list = new ArrayList<BigInteger>();
        // for(String elem : unsorted){
        //     list.add(new BigInteger(elem));
        // }
        // Collections.sort(list);
        // for(int i=0; i<unsorted.length; i++){
        //     unsorted[i] = list.get(i).toString();
        // }
        // return unsorted;
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()){
                    return -1;
                }else if(o1.length() > o2.length()){
                    return 1;
                }else{
                    BigInteger a = new BigInteger(o1);
                    BigInteger b = new BigInteger(o2);
                    if(a.compareTo(b) > 0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                
            }
        });
        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
