import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void printAnswer() {
        for(int i =0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }

    public static void choose(int currNum, int m, int n){
        if (answer.size() == n){
            printAnswer();
            return;
        }
        for(int i = 1; i<=m; i++){
            answer.add(i);
            choose(i,m,n);
            answer.remove(answer.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // Please write your code here.
        choose(1,k,n);
    }
}