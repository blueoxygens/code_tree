import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<5; i++){
            String[] input = sc.nextLine().trim().split(" ");
            for(String s: input) {
                System.out.print(s.toUpperCase()+ " ");
            }
            System.out.println();
        }
    }
}