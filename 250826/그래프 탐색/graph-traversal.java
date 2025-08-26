import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] u = new int[m];
        int[] v = new int[m];

        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // Please write your code here.
        List <ArrayList<Integer>> node = new ArrayList<>();
        for (int i = 0; i <n; i++){
            node.add(new ArrayList<Integer>());
        }

        for (int i = 0; i <m; i++){
            node.get(u[i]-1).add(v[i]-1);
            node.get(v[i]-1).add(u[i]-1);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        // System.out.println(node);

        q.add(0);

        while(!q.isEmpty()){
            int target = q.pollFirst();
            if(!set.contains(target)){
                for (int num : node.get(target)){
                    q.add(num);
                }
                set.add(target);
                ans += 1;
            }
        }

        System.out.println(ans-1);
    }
}