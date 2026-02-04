import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        char[] dirA = new char[n];
        int [] secA = new int[n];
        char[] dirB = new char[m];
        int [] secB = new int[m];

        for (int i = 0; i < n; i++){
            dirA[i] = sc.next().charAt(0);
            secA[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++){
            dirB[i] = sc.next().charAt(0);
            secB[i] = sc.nextInt();
        }
        boolean flag = false;
        int a = 0;
        int b = 0;
        int aIndex = 0;
        int aSec = 0;
        int bIndex = 0;
        int bSec = 0;
        int sec = 0;
        while (!flag){
            sec += 1;
            aSec += 1;
            bSec += 1;
            if (aSec > secA[aIndex]){
                aSec = 1;
                aIndex += 1;
            }
            if (bSec > secB[bIndex]){
                bSec = 1;
                bIndex += 1;
            }
            switch(dirA[aIndex]){
                case 'R':
                    a += 1;
                    break;
                case 'L':
                    a -= 1;
                    break;
            }
            switch(dirB[bIndex]){
                case 'R':
                    b += 1;
                    break;
                case 'L':
                    b -= 1;
                    break;
            }
            if (a == b){
                flag = true;
            }
        }
        System.out.println(sec);
    }
}