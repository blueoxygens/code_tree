import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        // Please write your code here.
        int max = 0;
        int[] range = new int [2];
        range[0] = Arrays.stream(x1).min().getAsInt();
        range[1] = Arrays.stream(x2).max().getAsInt();
        
        for(int i =range[0]; i<=range[1]; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(x1[j]<=i && x2[j]>=i || x1[j]>=i && x2[j]<=i){
                    count += 1;
                }
            }
            if(max<count){
                max = count;
            }
        }

        System.out.println(max);
    }
}