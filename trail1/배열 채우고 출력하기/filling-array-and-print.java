import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
                            // .toArray();
        for(int i = input.length-1; i>-1; i--){
            System.out.print(input[i]);
        }
    }
}