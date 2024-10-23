
/*
문제
S배열과 , k의 수가 주어지는데 s배열에서 두 수의 합이 k랑 가장 가까운 두 정수의 조합의 수

입력 값
테스트 케이스의 개수
n k
배열
~ 반복

풀이
정렬 후 투포인터로 처리

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        while (t-- > 0) {
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]); // 배열의 크기
            int K = Integer.parseInt(firstLine[1]); // 목표 합

            String[] secondLine = br.readLine().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(secondLine[i]);
            }

            // 배열을 정렬
            Arrays.sort(arr);

            // 투 포인터 설정
            int left = 0;
            int right = n - 1;
            int closestSum = Integer.MAX_VALUE;
            int count = 0;

            while (left < right) {
                int sum = arr[left] + arr[right];

                // 현재 합이 목표값에 가까운지 확인
                int diff = Math.abs(sum - K);

                if (diff < closestSum) {
                    closestSum = diff; // 가장 가까운 합 갱신
                    count = 1; // 새로운 가장 가까운 값 발견 시 카운트를 1로 초기화
                } else if (diff == closestSum) {
                    count++; // 동일한 가장 가까운 값이 발견되면 카운트 증가
                }

                // 목표값보다 크면 오른쪽 포인터를 왼쪽으로
                if (sum > K) {
                    right--;
                } else {
                    left++;
                }
            }

            // 결과 출력
            System.out.println(count);
        }
    }
}






