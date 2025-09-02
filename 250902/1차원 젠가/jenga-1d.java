import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
// import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        // Please write your code here.
        for (int i = 0; i<2; i++){
            if(i == 0){
                int[] t1 = Arrays.copyOfRange(blocks, 0, s1-1);
                int[] t2 = Arrays.copyOfRange(blocks, e1, blocks.length);
                blocks = IntStream.concat(Arrays.stream(t1), Arrays.stream(t2)).toArray();
            }else{
                int[] t1 = Arrays.copyOfRange(blocks, 0, s2-1);
                int[] t2 = Arrays.copyOfRange(blocks, e2, blocks.length);
                blocks = IntStream.concat(Arrays.stream(t1), Arrays.stream(t2)).toArray();
            }
        }
        System.out.println(blocks.length);
        Arrays.stream(blocks)
                .forEach(System.out::println);
    }
}