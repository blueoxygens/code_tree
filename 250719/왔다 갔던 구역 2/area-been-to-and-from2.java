import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] field = new int [200];
        int pivot = 99;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.
            if (dir == 'R'){
                for(int j = pivot; j <= pivot + x; j ++){
                    field[j] += 1;
                }
                pivot += x;
            }else{
                for(int j = pivot; j >= pivot - x; j --){
                    field[j] += 1;
                }
                pivot -= x;
            }
        }
        int ans = 0;
        for(int i = 0; i < 200; i++){
            if(field[i]>=2){
                int len = 0;
                int temp = i;
                while(field[temp] >=2){
                    len += 1;
                    temp++;
                }
                ans += len -1;
                i = temp ++;
            }
        }
        System.out.println(ans);
    }
}