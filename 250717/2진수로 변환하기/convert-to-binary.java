import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] digits = new int[20];
        int counter = 0;

        while(true) {
            if(n<2) {
                digits[counter++] = n;
                break;
            }

            digits[counter++] = n % 2;
            n /= 2;
        }

        for(int i = counter-1; i>=0; i--){
            System.out.print(digits[i]);
        }
    }
}