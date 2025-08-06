
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0 ;i < N; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }


        int start = 0;
        int end = 0;
        int sum =0;

        int minLen = Integer.MAX_VALUE;

        while (end <= N) {
            if (sum >= S) {
                // 조건 만족 → 줄여보기
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                break; // 더 이상 확장 불가능
            } else {
                // 조건 미만 → 확장하기
                sum += arr[end++];
            }
        }


        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);



    }

}
