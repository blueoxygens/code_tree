import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] field = new int[200][200];
        int pivot = 100;
        
        int count = 0;
        for (int i = 0; i< n; i++){
            for (int x = x1[i]; x < x2[i]; x++){
                for(int y = y1[i]; y < y2[i]; y++){
                    if(field[x+pivot][y+pivot] != 1){
                        field[x+pivot][y+pivot] = 1;
                        count += 1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}