import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer,Integer>hash = new TreeMap<>();
        for(int i = 0; i<n; i ++){
            if(!hash.containsKey(arr[i])){
                hash.put(arr[i], i+1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer,Integer> e : hash.entrySet()){
            sb.append(e.getKey()).append(' ').append(e.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}