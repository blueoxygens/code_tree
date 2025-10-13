import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        // --- 수정된 순환 코드 (l -> r -> d -> l) ---
        for (int i = 0; i < t; i++) {
            // 각 배열의 순환 이동에 필요한 끝/시작 원소 임시 저장
            int l_end = l[n - 1]; // l -> r
            int r_end = r[n - 1]; // r -> d
            int d_end = d[n - 1]; // d -> l

            // 1. l -> r 순환
            int[] new_r = new int[n];
            for (int j = 1; j < n; j++) {
                new_r[j] = r[j - 1]; // r 배열의 모든 원소는 오른쪽으로 한 칸 이동
            }
            new_r[0] = l_end; // l의 마지막 원소가 r의 첫 번째 원소로
            
            // 2. r -> d 순환
            int[] new_d = new int[n];
            for (int j = 1; j < n; j++) {
                new_d[j] = d[j - 1]; // d 배열의 모든 원소는 오른쪽으로 한 칸 이동
            }
            new_d[0] = r_end; // r의 마지막 원소가 d의 첫 번째 원소로
            
            // 3. d -> l 순환
            int[] new_l = new int[n];
            for (int j = 1; j < n; j++) {
                new_l[j] = l[j - 1]; // l 배열의 모든 원소는 오른쪽으로 한 칸 이동
            }
            new_l[0] = d_end; // d의 마지막 원소가 l의 첫 번째 원소로

            // 배열 업데이트
            r = new_r;
            d = new_d;
            l = new_l;
        }
        // --- 순환 코드 끝 ---

        // StringBuilder를 사용하여 출력
        System.out.println(arrayToString(l));
        System.out.println(arrayToString(r));
        System.out.println(arrayToString(d));
        
        sc.close();
    }
    
    /**
     * 배열을 받아 원소들을 공백으로 구분한 문자열로 반환합니다.
     */
    public static String arrayToString(int[] arr) {
        if (arr.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            // 마지막 원소가 아니면 공백을 추가
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}