

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int sum =0;

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
            if(i<K) sum += arr[i];
        }

        int max = sum;

        for(int i=K; i< N; i++){
            sum = sum - arr[i-K] + arr[i];
            max = Math.max(max,sum);
        }

        System.out.println(max);


    }

}
