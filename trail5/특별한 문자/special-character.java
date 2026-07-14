import java.util.*;


public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Map<Character, Integer>hash = new LinkedHashMap<>();
        for(Character c : str.toCharArray()){
            hash.merge(c, 1, Integer::sum);
        }

        String ans = "None";

        for(Map.Entry<Character, Integer> e : hash.entrySet()){
            Character c = e.getKey();
            int v = e.getValue();
            if (v == 1){
                ans = c.toString();
                break;
            }
        }

        System.out.println(ans);
    }
}