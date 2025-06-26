import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int result = 0;
        if(m1==1||m1==3||m1==5||m1==7||m1==8||m1==10||m1==12){
            result += 31-d1+1;
        }else if(m1==2){
            result += 28-d1+1;
        }else{
            result += 30-d1+1;
        }
        m1 += 1;
        while(m1 < m2){
            if(m1==1||m1==3||m1==5||m1==7||m1==8||m1==10||m1==12){
                result += 31;
            }else if(m1==2){
                result += 28;
            }else{
                result += 30;
            }
            m1 += 1;
        }
        result += d2;
        System.out.println(result);
    }
}