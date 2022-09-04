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

class Result {

    /*
    * Complete the 'kruskals' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
    */

    /*
    * For the weighted graph, <name>:
    *
    * 1. The number of nodes is <name>Nodes.
    * 2. The number of edges is <name>Edges.
    * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
    *
    */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int[][] graph = new int[gNodes][gNodes];
        for(int i=0; i<gFrom.size(); i++){
            graph[gFrom.get(i)-1][gTo.get(i)-1] = gWeight.get(i);
            graph[gTo.get(i)-1][gFrom.get(i)-1] = gWeight.get(i);
        }
        
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println("-");
        }

        int totalWeight = solve(0, 1, graph);
        System.out.println("Result : " +totalWeight);
        return totalWeight;
    }

    private static int solve(int i, int j, int[][] graph) {
        if(i >= graph.length || j >= graph.length ){
            return 0;
        }
        if(graph[i][j] == 0){
            j++;
            return solve(i, j, graph);
        }

        int totalWeight = graph[i][j];

        
        System.out.println("called i:"+i+", j="+j+" with value = "+totalWeight);
        int w1 = solve(i, j+1, graph); System.out.println("calling i:"+i+", j="+(j+1)+" with result : "+w1);
        int w2 = solve(j, j+1, graph); System.out.println("calling i:"+j+", j="+(j+1)+" with result : "+w2);
        
        
        if(w1 < w2){
            System.out.println("for i="+i+"& j="+j+"totalWeight is :"+totalWeight+" adding to totalWeight: "+(totalWeight + w1));
            return (totalWeight + w1);
        }
        else{
            System.out.println("for i="+i+"& j="+j+"totalWeight is :"+totalWeight+" adding to totalWeight: "+(totalWeight + w2));
            return (totalWeight + w2);
        }
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(res+"");
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
