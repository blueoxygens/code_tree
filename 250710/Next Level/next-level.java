import java.util.Scanner;

class Agent{
    String id = "codetree";
    int lv = 10;

    public Agent() {
        String id = "codetree";
        int lv = 10;
    }

    public Agent(String id, int lv) {
        this.id = id;
        this.lv = lv;
    }

    public void print(){
        System.out.println("user " + this.id + " lv " + this.lv);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.
        Agent a1 = new Agent();
        a1.print();
        Agent a2 = new Agent(id, level);
        a2.print();
    }
}