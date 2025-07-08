import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.
        char[] arr1 = word1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr2);
        boolean flag = true;
        if (arr1.length == arr2.length){
            for(int i = 0; i<arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    flag = false;
                    break;
                }
            }
        }else{
            flag = false;
        }

        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}