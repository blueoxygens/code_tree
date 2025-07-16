import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.
        String [] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int [] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        int pivot = 0;
        int count = 0;
        int day = 0;

        for(int i = 0; i<7; i++){
            if (A.equals(week[i])){
                pivot = i;
                break;
            }
        }
        // System.out.println(pivot);
        if(m1 == m2){
            day = d2 - d1;
            count = (day-pivot+1)/7;
        }else{
            // if(A == "Mon") count += 1;
            day += days[m1-1] - d1+1;
            // count += (day+pivot+1)/7;
            // System.out.println(count);
            for(int i = m1; i<m2-1; i++){
                day += days[i];
                // if(A != "Mon") count += 1;
                // System.out.println(count);
            }
            day += d2;
            // count += (d2+pivot+1) /7;
            // if(A != "Mon") count += 1;
            if (pivot < day%7){
                count = (day)/7 + 1;
            }else{
                count = (day)/7;
            }
            }
        System.out.println(count);
    }
}