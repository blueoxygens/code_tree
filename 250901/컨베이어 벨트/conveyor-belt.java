import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        // Please write your code here.

        ArrayDeque<Integer> topq = new ArrayDeque<>(Arrays.stream(top)
                                                .boxed()
                                                .collect(Collectors.toList()));
       ArrayDeque<Integer> bottomq = new ArrayDeque<>(Arrays.stream(bottom)
                                                .boxed()
                                                .collect(Collectors.toList()));
        for(int i = 0; i < t; i++){
            int tempt = topq.pollLast();
            int tempb = bottomq.pollLast();
            topq.addFirst(tempb);
            bottomq.addFirst(tempt);
        }
        while(!topq.isEmpty()){
            System.out.print(topq.pollFirst()+" ");
        }
        System.out.println("");
        while(!bottomq.isEmpty()){
            System.out.print(bottomq.pollFirst()+" ");
        }
    }
}