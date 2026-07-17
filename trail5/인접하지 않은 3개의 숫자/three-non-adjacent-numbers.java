import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int ans = 0;

        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = numbers[0];
        r[n-1] = numbers[n-1];

        for(int i=1; i < n; i ++){
            l[i] = Math.max(l[i-1],numbers[i]);
            r[n-i-1] = Math.max(r[n-i],numbers[n-i-1]);
        }

        for(int i = 2; i< n-2; i++){
            ans = Math.max(l[i-2]+r[i+2]+numbers[i], ans);
        }

        System.out.println(ans);
    }
}