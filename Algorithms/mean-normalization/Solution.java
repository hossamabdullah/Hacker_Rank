import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer[]> data = new ArrayList<>();
        List<Integer> allElements = new ArrayList<>();
        for(int nn=0 ; nn < n; nn++){
            int length = in.nextInt();   
            Integer[] elements = new Integer[length];
            for(int l =0; l<length; l++){
                elements[l] = in.nextInt();
                allElements.add(elements[l]);
            }
            data.add(elements);
        }

        //before solution
        // System.out.println(data.size());
        // for(int i=0; i<allElements.size(); i++){
        //     System.out.println(allElements.get(i));
        // }
        // Integer[] xdata = data.get(0);
        // for(int i=0; i<xdata.length; i++){
        //     System.out.println(xdata[i]);
        // }

        //solution
        double min = 0;
        for(int i=0; i<n; i++){
            Integer[] xData = data.get(i);
            double xValue = 0;
            for(Integer elem: xData){
                xValue += elem;
            }
            xValue /= xData.length;
            double xResult = 0;
            for(int j=0; j<allElements.size(); j++){
                xResult += Math.abs(allElements.get(i) - xValue);
            }
            System.out.println(xResult);
            if(i==0 || xResult < min){
                min = xResult;
            }
        }
        System.out.println(min);

    }

}