import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        if(A<11){
            System.out.println(-1);
        }else if(A==11&&((11*60+11)-(B*60+C)>0)){
            System.out.println(-1);
        }else{
            int result = -(11*60+11);
            result += (A-11)*24*60;
            result += B*60;
            result += C;
            System.out.println(result);
        }
    }
}