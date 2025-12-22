import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<4; i++){
            String[] input = sc.nextLine().trim().split(" ");
            int sum = 0;
            for (String s : input) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}