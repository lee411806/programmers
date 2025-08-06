

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] stairs = new int[N];

        for(int i=0 ; i<N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st1.nextToken());
        }

        int[] dp = new int[N];

        dp[0] =stairs[0];

        if(N>=2){
            dp[1] = stairs[0] + stairs[1];
        }

        if(N>=3){
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        }

        for(int i=3 ; i<N;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+ stairs[i-1]) +stairs[i];
        }

        System.out.println(dp[N-1]);

    }
}
