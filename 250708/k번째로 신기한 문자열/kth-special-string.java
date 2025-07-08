import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // Please write your code here.
        String REG_EXP = "^"+t+"\\w*$";
        ArrayDeque<String>dq = new ArrayDeque<String>();
        for(String word: words){
            if(Pattern.matches(REG_EXP, word)){
                dq.add(word);
            }
        }
        Object[] arr = dq.toArray();
        Arrays.sort(arr);
        /*for(int i =0; i<arr.length; i++){
            System.out.println(String.valueOf((String)arr[i]));
        }*/
        System.out.println(arr[k-1]);
    }
}