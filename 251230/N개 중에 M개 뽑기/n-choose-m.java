import java.util.*;

public class Main {
    static List<List<Integer>> ans = new ArrayList<>();
    static int n, m;
    
    static void backtracking(List<Integer> arr, int start){
        if(arr.size() == m ){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i = start; i <= n; i++){
            arr.add(i);
            backtracking(arr, i+1);
            arr.remove(arr.size()-1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        backtracking(new ArrayList<>(), 1);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : ans){
            for(int num : list){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}