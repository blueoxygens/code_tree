import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        // Please write your code here.
        int l = A.length();
        StringBuilder sb = new StringBuilder();

        if (A.charAt(0) == A.charAt(l-1)){
            // System.out.println(l);
            int start = l-1;
            int pivot = 0;
            int length = 0;
            for(int end=l-1; end > -1; end--){
                if(A.charAt(end) == A.charAt(start)){
                    length ++;
                }
                else{
                    pivot = end+1;
                    break;
                }
            }
            start = 0;
            for(int end=0; end < pivot; end++){
                if(A.charAt(end) == A.charAt(start)){
                    length ++;
                }
                else{
                    sb.append(Character.toString(A.charAt(start)));
                    sb.append(Integer.toString(length));
                    start = end;
                    length = 1;
                }
            }
            sb.append(Character.toString(A.charAt(start)));
            sb.append(Integer.toString(length));
        }
        else {
            int start = 0;
            int length = 0;
            for(int end=0; end < l; end++){
                if(A.charAt(end) == A.charAt(start)){
                    length ++;
                }
                else{
                    sb.append(Character.toString(A.charAt(start)));
                    sb.append(Integer.toString(length));
                    start = end;
                    length = 1;
                }
            }
            sb.append(Character.toString(A.charAt(start)));
            sb.append(Integer.toString(length));
        }
        System.out.println(sb.length());
    }
}