

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int[] prefixSum = new int[N+1];
        for(int i=1; i<=N; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        for(int i=0 ; i<M ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            System.out.println(prefixSum[y]-prefixSum[x-1]);
        }

    }
}
