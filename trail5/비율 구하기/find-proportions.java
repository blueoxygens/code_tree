import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer>counter = new TreeMap<>();

        for(int i = 0; i < n; i++){
            counter.merge(sc.next(),1,Integer::sum);
        }

        for(Map.Entry<String,Integer> e : counter.entrySet()){
            System.out.printf("%s %.4f\n",e.getKey(), (float)e.getValue()*100/n);
        }
    }
}