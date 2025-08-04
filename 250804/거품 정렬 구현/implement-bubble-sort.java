import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // Please write your code here.
        boolean set = true;
        do{
            set = true;
            for(int i = 0; i< arr.length-1; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    set = false;
                }
            }
        }
        while(set == false);

        for(int i : arr){
            System.out.print(i + " ");
        }    
    }
}