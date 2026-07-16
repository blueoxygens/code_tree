import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[]seq = new char[n];

        for(int i = 0; i < n; i++){
            seq[i] = sc.next().charAt(0);
        }

        //h 주먹 s 가위 p  보자기 h

        Map<Character, Character> hash = new HashMap<>();
        hash.put('P','S');
        hash.put('S','H');
        hash.put('H','P');

        char[] win = new char[n];
        for(int i = 0; i < n; i++){
            win[i] = hash.get(seq[i]);
        }

        int[][] sum = new int[3][n];

        for(int i = 0; i< n; i++){
            if(win[i] == 'H'){
                if(i == 0){
                    sum[0][0] = 1;
                }
                else{
                    sum[0][i] = sum[0][i-1] + 1;
                    sum[1][i] = sum[1][i-1];
                    sum[2][i] = sum[2][i-1];
                }
            }else if(win[i] == 'S'){
                if(i == 0){
                    sum[1][0] = 1;
                }
                else{
                    sum[1][i] = sum[1][i-1] + 1;
                    sum[2][i] = sum[2][i-1];
                    sum[0][i] = sum[0][i-1];
                }
            }else{
                if(i == 0){
                    sum[2][0] = 1;
                }
                else{
                    sum[2][i] = sum[2][i-1] + 1;
                    sum[1][i] = sum[1][i-1];
                    sum[0][i] = sum[0][i-1];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) ans = Math.max(ans, sum[i][n-1]);

        for (int t = 1; t < n; t++) {
            int left = 0, right = 0;
            for (int i = 0; i < 3; i++) {
                left  = Math.max(left,  sum[i][t-1]);
                right = Math.max(right, sum[i][n-1] - sum[i][t-1]);
            }
            ans = Math.max(ans, left + right);
        }

        System.out.println(ans);
    }
}