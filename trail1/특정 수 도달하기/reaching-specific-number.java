import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] input = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int total = 0;
        int num = 0;
        for(int i = 0; i<input.length; i++){
            if (input[i] >= 250){
                break;
            }
            total += input[i];
            num += 1;
            
        }
        System.out.println(total + " " + String.format("%.1f",(double)total/num));
    }
}