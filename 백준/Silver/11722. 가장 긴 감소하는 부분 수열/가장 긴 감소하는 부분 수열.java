/*
문제
바이토닉 수열 -> lis에 감소하는 부분까지 추가

풀이
1. lds 구하는 식에서 두수를 비교할 때 작다라는 조건만 바꾸면 됨
2. lds -> 동적 배열로 구현
3. 마지막 동적배열에서 최대값 구함
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.fill(dp,1);
        int result = lds(arr,dp,N);
        System.out.println(result);

    }

    public static int lds(int[] arr, int[] dp, int N){

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxVal) {
                maxVal = dp[i];
            }
        }

        return maxVal;


    }
}






