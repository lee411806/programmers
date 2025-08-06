

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int dp[] = new int[N];

        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
            dp[i] = 1;
        }


        for(int i=0 ; i<N ; i++){
            for(int j=0; j<i; j++){

                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

    }
}
