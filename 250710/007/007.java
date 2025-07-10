import java.util.Scanner;

class ex {
    String code;
    char point;
    int time;

    public ex(String code, char point, int time){
        this.code = code;
        this.point = point;
        this.time = time;
    }

    public void print() {
        System.out.println("secret code : " + this.code);
        System.out.println("meeting point : " + this.point);
        System.out.println("time : " + this.time);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode;
        char mPoint;
        int time;
        // Please write your code here.
        sCode = sc.next();
        mPoint = sc.next().charAt(0);
        time = sc.nextInt();
        ex temp = new ex(sCode, mPoint, time);
        temp.print();
    }  
}