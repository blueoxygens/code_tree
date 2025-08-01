import java.util.Scanner;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        LinkedList <Integer> list = new LinkedList<>(); 

        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().trim().split(" ");
            // Please write your code here.
            // System.out.println(command[0]);
            if (command.length > 1){
                if(command[0].equals("push_front")){
                    list.addFirst(Integer.parseInt(command[1]));
                }else{
                    list.addLast(Integer.parseInt(command[1]));
                }
            }else{
                switch(command[0]){
                    case "pop_front":
                        System.out.println(list.pollFirst());
                        break;
                    case "front":
                        System.out.println(list.peekFirst());
                        break;
                    case "pop_back":
                        System.out.println(list.pollLast());
                        break;
                    case "empty":
                        System.out.println(list.isEmpty()? 1 : 0 );
                        break;
                    case "size":
                        System.out.println(list.size());
                        break;
                    case "back":
                        System.out.println(list.peekLast());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}