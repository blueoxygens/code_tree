import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        String[] week = {"Mon", "Tue","Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int gap = 0;
        
        if(m1 == m2){
            if(d1 > d2){
                gap = 7-(d1 -d2)%7;  
            } else if (d1 < d2){
                gap = (d2-d1)%7;
            }else{
                gap = 0;
            }
        } else if(m1 < m2){
            for(int i = m1-1; i<m2-1; i++ ){
                gap += month[i];
            }
            gap -= d1;
            gap += d2;
            gap = gap%7;
        }else{
            for(int i = m2-1; i<m1-1; i++ ){
                gap += month[i];
            }
            gap -= d2;
            gap += d1;
            gap = 7- gap%7;
        }
        
        System.out.println(week[gap]);
    }
}