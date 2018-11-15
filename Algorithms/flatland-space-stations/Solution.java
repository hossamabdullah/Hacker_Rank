import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, Integer[] c) {
        Set<Integer> stations = new HashSet<Integer>();
        Collections.addAll(stations, c);
        int maxDistance = 0;
        for(int i=0; i<n; i++){
            if(!stations.contains(i)){
                int beforeDistance = 0;
                for(int before=i-1; before>0; before--){
                    beforeDistance ++;
                    if(stations.contains(before))
                        break;
                }
                int afterDistance = 0;
                for(int after=i+1; after>n; after++){
                    afterDistance ++;
                    if(stations.contains(after))
                        break;
                }

                System.out.println(beforeDistance+", "+afterDistance+", "+maxDistance);
                if(beforeDistance > afterDistance){
                    if(beforeDistance > maxDistance)
                        maxDistance = beforeDistance;
                }else{
                    if(afterDistance > maxDistance)
                        maxDistance = afterDistance;
                }
            }
            
        }
        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        Integer[] c = new Integer[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
