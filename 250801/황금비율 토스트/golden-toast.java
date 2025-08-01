import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] s = sc.next().trim().toCharArray();
        sc.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        for(char c : s){
            list.add(c);
        }

        ListIterator<Character> it = list.listIterator(list.size());

        for (int i = 0; i < m; i++) {
            String[] command = sc.nextLine().trim().split(" ");
            switch (command[0]){
                case "L":
                    if(it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case "P":
                    it.add(command[1].charAt(0));
                    // System.out.println(command[1].charAt(0));
                    break;
                case "R":
                    if(it.hasNext()){
                        it.next();
                    }
                    break;
                case "D":
                    if(it.hasNext()){
                        it.next();
                        it.remove();
                    }
                    break;
                default:
                    break;
            }
        }
        it = list.listIterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        
        // Please write your code here.

        //L 앞으로, R 뒤로, 뒤에 있는 요소 삭제, P &는 &라는 문자가 적혀있는 식빵을 추가 
        
    }
}