import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        char[] dirA = new char[n];
        int[] secA = new int[n];
        char[] dirB = new char[m];
        int[] secB = new int[m];

        for (int i = 0; i < n; i++) {
            dirA[i] = sc.next().charAt(0);
            secA[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            dirB[i] = sc.next().charAt(0);
            secB[i] = sc.nextInt();
        }

        int aPos = 0, bPos = 0;
        int aIdx = 0, bIdx = 0;
        int aCurSec = 0, bCurSec = 0;
        int time = 0;
        int ans = -1;

        while (aIdx < n || bIdx < m) {
            time++;

            if (aIdx < n) {
                if (dirA[aIdx] == 'R') aPos++;
                else aPos--;
                
                aCurSec++;
                if (aCurSec == secA[aIdx]) {
                    aCurSec = 0;
                    aIdx++;
                }
            }

            if (bIdx < m) {
                if (dirB[bIdx] == 'R') bPos++;
                else bPos--;
                
                bCurSec++;
                if (bCurSec == secB[bIdx]) {
                    bCurSec = 0;
                    bIdx++;
                }
            }

            if (aPos == bPos) {
                ans = time;
                break;
            }
        }

        System.out.println(ans);
    }
}