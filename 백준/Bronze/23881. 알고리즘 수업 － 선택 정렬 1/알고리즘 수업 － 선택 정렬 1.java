
/*
문제
N개의 서로 다른 양의 정수가 저장된 배열 A
선택정렬로 오름차순으로 정렬 k번째 교환되는 수 구하기

입력 값
N k
N개수만큼의 배열

풀이
선택정렬 코드로 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 배열 크기
        int K = Integer.parseInt(st.nextToken());  // K번째 교환

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 배열 값 입력
        }

        int count = 0;  // 교환 횟수

        // 선택 정렬 구현
        for (int last = N - 1; last > 0; last--) {
            int maxIdx = 0;  // 가장 큰 수의 인덱스
            for (int i = 1; i <= last; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }

            // 교환이 필요한 경우
            if (maxIdx != last) {
                // 교환
                int temp = arr[last];
                arr[last] = arr[maxIdx];
                arr[maxIdx] = temp;

                count++;  // 교환 횟수 증가

                // K번째 교환이면 작은 값부터 출력
                if (count == K) {
                    System.out.println(Math.min(arr[last], arr[maxIdx]) + " " + Math.max(arr[last], arr[maxIdx]));
                    return;
                }
            }
        }

        // K번째 교환이 발생하지 않은 경우
        System.out.println(-1);
    }
}




