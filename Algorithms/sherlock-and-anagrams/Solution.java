    import java.io.*;
    import java.math.*;
    import java.security.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.regex.*;
    import java.util.stream.Collectors;

    public class Solution {

        // Complete the sherlockAndAnagrams function below.
        static int sherlockAndAnagrams(String s) {
            int count = 0;
            Map<String, Integer> results = new HashMap<>();
            for(int i=1; i<s.length(); i++){
                for(int j=0; j<s.length() && j+i <= s.length(); j++){
                    String slice = sortString(s.substring(j, j+i));
                    if(results.containsKey(slice))    results.put(slice, results.get(slice) + 1);
                    else                              results.put(slice, 1);
                }
            }
            count = results.keySet().stream().mapToInt(i -> summation(results.get(i)-1)).sum();
            return count;
        }

        private static int summation(int n){
            return (n*(n+1))/2;
        }

        public static String sortString(String inputString){
            char tempArray[] = inputString.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray);
        }

        private static Set<Character> convertFromArrayToSet(char[] data){
            Set<Character> dataDuplicateFree = new HashSet<>();
            for(int i=0; i<data.length; i++){
                dataDuplicateFree.add(data[i]);
            }
            return dataDuplicateFree;
        }
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String s = scanner.nextLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }
    }
