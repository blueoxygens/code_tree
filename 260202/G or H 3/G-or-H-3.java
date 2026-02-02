import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Map <Integer, Character> m = new HashMap<>();
        boolean[] b = new boolean[10000];
        int end = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            end = Math.max(end, pos);
            char c = sc.next().charAt(0);
            m.put(pos, c);
            b[pos] = true;
        }
        // Please write your code here.

        for (int i = 1; i <= end-k+1; i++){
            if(!b[i]){
                continue;
            }
            int s = 0;
            for(int j = i; j <= i+k; j++){
                if(!b[j]){
                    continue;
                }
                if ('G' == m.get(j)){
                    s += 1;
                }else{
                    s += 2;
                }
            }
            ans = Math.max(s,ans);
        }
        System.out.println(ans);
    }
}