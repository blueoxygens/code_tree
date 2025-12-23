import java.util.Scanner;

public class Main {
    // 임시 저장 공간을 static으로 선언하여 불필요한 생성을 방지합니다.
    static int[] sorted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return; // 입력값이 없을 경우 대비
        int n = sc.nextInt();
        int[] arr = new int[n];
        sorted = new int[n]; // 입력받은 n 크기만큼 초기화

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 병합 정렬 시작 (시작 인덱스 0, 끝 인덱스 n-1)
        sort(arr, 0, n - 1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int data : arr) {
            sb.append(data).append(" ");
        }
        System.out.println(sb.toString().trim());
        
        sc.close();
    }

    // 분할(Divide) 메서드
    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            sort(arr, low, mid);       // 왼쪽 절반 분할
            sort(arr, mid + 1, high);  // 오른쪽 절반 분할
            merge(arr, low, mid, high); // 병합
        }
    }

    // 병합(Merge) 메서드
    static void merge(int[] arr, int low, int mid, int high) {
        int i = low;     // 왼쪽 부분 시작점
        int j = mid + 1; // 오른쪽 부분 시작점
        int k = low;     // sorted 배열 채울 인덱스

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        // 남은 요소들 복사
        while (i <= mid) sorted[k++] = arr[i++];
        while (j <= high) sorted[k++] = arr[j++];

        // sorted에서 원본 arr로 다시 복사
        for (int l = low; l <= high; l++) {
            arr[l] = sorted[l];
        }
    }
}