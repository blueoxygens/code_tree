import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int num = 0;

        for (int i = 0; i < n.length(); i ++){
            if(n.charAt(i) == '1'){
                num += Math.pow(2, n.length() -1 - i);
            }
        }
        // System.out.println(num);
        
        StringBuilder sb = new StringBuilder();

        if(num == 0){
            System.out.println(0);
        }else{
            num *= 17;
            while(num > 0){
                sb.append(num % 2);
                num /= 2;
            }
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}