import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer>tree = new TreeMap<>();

        for(int i = 0; i < n; i++){
            tree.merge(sc.next(), 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Integer> e : tree.entrySet()){
            sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        System.out.println(sb.toString());
    }
}