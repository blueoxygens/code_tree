import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        StringBuilder sb = new StringBuilder();

        if(n == 0){
            sb.append(0);
        }else{
            while(n > 0){
                sb.append(n%b);
                n/=b;
            }
        }

        sb.reverse();
        System.out.println(sb.toString());
    }
}