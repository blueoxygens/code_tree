import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // Please write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String[] op = sc.nextLine().trim().split(" ");
        
            if(op.length > 1){
                if(op[0].equals("push_back")){
                    // System.out.println(list.add(Integer.parseInt(op[1])));
                    list.add(Integer.parseInt(op[1]));
                }else{
                    System.out.println(list.get(Integer.parseInt(op[1])-1));
                }
            }
            else{
                if(op[0].equals("size")){
                    System.out.println(list.size());
                }else{
                    list.remove(list.size() -1);
                }
            }
        }
    }
}