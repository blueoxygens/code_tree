import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] input = Arrays.stream(br.readLine().split(" "))
                            .mapToDouble(Double::parseDouble)
                            .toArray();
        
        double total = 0;
        for(int i = 0; i<input.length; i++){
            total += input[i];
        }
        System.out.println(String.format("%.1f", total/input.length));
    }
}