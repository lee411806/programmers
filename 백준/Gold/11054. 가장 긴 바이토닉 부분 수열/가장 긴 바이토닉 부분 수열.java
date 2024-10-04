import java.io.*;
import java.util.*;

/*
 * i를 기준으로 LIS와 LDS의 합 -> 바이토닉? 수열의 합
 * LIS는 자기 자신(i)을 포함하고 있기 때문에 하나 빼주어야 함.
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //동적배열
        int[] LIS = new int[N];
        int[] LDS = new int[N];
        
        //LIS구함
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        //LDS구함
        for (int i = N - 1; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = N - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        
        // 둘이 더해서 가장 큰 수가 바이토닉수열 ,, 에서 자기자신 1빼줘야함(중복)
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(LIS[i] + LDS[i] - 1, max);
        }

        System.out.println(max);
    }
}