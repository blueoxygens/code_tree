import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double[] input = Arrays.stream(br.readLine().split(" "))
                                .mapToDouble(Double::parseDouble)
                                .toArray();
        
        double total = 0.0;
        for(double temp : input){
            total += temp;
        }
        double average = total/input.length;
        System.out.println(String.format("%.1f",average));

        if (average >= 4.0){
            System.out.println("Perfect");
        }
        else if (average >= 3.0){
            System.out.println("Good");
        }
        else{
            System.out.println("Poor");
        }
    }
}