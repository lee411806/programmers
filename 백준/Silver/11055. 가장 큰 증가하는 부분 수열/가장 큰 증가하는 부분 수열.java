/*
문제
수열의 증가하는 부분 수열에서 합이 가장 큰 것

풀이
1. lis 구하는 코드 만듬
2. 각 i 마다 연속수열 최장길이를 구하는 것임으로 똑같이 길이를 합으로 적용해주면 됨
3. i의 요소일때 연속수열 최대 합 변수 , 전체 최대 합 변수 설정하고 둘이 비교하면서 반복문 돌리면 됨
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        //입력 값 받기 : 요소의 개수 ,요소
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
//            System.out.print(arr[i]+" ");
        }


        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
        }

        int result = lisSumMax(arr,dp,N);
        System.out.println(result);

    }

    public static int lisSumMax(int[] arr, int[] dp, int N){



        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                   dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;

    }
}






