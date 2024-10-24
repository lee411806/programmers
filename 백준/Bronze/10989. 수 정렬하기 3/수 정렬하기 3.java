
/*
문제
10000보다 작거나 같은 자연수의 범위인 수들을 오름차순 정렬

입력 값
수의 개수 N
배열 값

풀이
계수정렬, 배열 자체 정렬 활용
카운팅 정렬의 시간 복잡도는 O(N + K) + 메모리 크기를 가정했을 때 숫자 범위가 작으면 계수 정렬도 효과적

참고
일반 Arrays.sort 정렬 nlon(n) 시간 복잡도
카운팅 정렬 O(n+k) 시간복잡도 -> 둘을 비교했을 때 크기가 작으면 카운팅 정렬이 더 효과적
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];  // 숫자의 범위가 0부터 10,000까지이므로 10001 크기의 배열 사용

        // 입력받은 숫자의 개수를 count 배열에 저장
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }

        // count 배열을 순회하며 숫자들을 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}






