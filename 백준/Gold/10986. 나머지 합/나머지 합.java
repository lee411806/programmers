import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        long[] prefixSum = new long[N + 1]; // ✅ int → long

        // 1. 누적합 prefix 배열 만들기
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // 2. 나머지 별 개수 세기
        long[] count = new long[M];
        for (int i = 0; i <= N; i++) {
            int mod = (int) (prefixSum[i] % M);
            if (mod < 0) mod += M; // 음수 나머지 보정
            count[mod]++;
        }

        // 3. 같은 나머지를 가진 쌍의 개수 세기
        long result = 0;
        for (int i = 0; i < M; i++) {
            if (count[i] >= 2) {
                result += (count[i] * (count[i] - 1)) / 2; // nC2
            }
        }
        System.out.println(result);
    }
}
