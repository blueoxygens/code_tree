import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        char[] arr = binary.toCharArray();
        // System.out.println(arr[0]);
        // System.out.println(binary.charAt(0));
        int answer = 0;
        for(int i =0; i<arr.length; i++){
            answer += Integer.parseInt(Character.toString(arr[arr.length-1-i]))*Math.pow(2,i);
        }
        System.out.print(answer);
    }
}