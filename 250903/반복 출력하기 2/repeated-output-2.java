import java.util.Scanner;
public class Main {
    static void print(int n){
        if(n == 0){
            return;
        }
        else{
            System.out.println("HelloWorld");
            print(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);
    }
}