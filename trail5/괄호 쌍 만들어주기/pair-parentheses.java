import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        char[] in = sc.nextLine().toCharArray();
        int l = in.length;

        int[] open = new int[l];
        int[] close = new int[l];

        for(int i = 1; i < l; i++){
            if(in[i-1] == '(' && in[i] == '(') open[i] = open[i-1] + 1;
            else open[i] = open[i-1];
            if(in[l - i] == ')' && in[l - i - 1] == ')') close[l - i] = close[l - i-1] + 1;
            else close[l - i] = close[l - i-1];
        }

        long ans = 0;

        for(int i = 0; i< l; i++){
            ans += open[i] * close[i];
        }

        System.out.println(ans);
    }
}