import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        oneton(n);
        ntoone(n);
    }
    static void oneton(int n){
        for (int i = 1; i<=n; i++){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    static void ntoone(int n){
        for (int i = n; i>0; i--){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}