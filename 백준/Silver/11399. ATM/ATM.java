

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1 ; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] presum = new int[N+1];
        int sum =0;
        for(int i=1 ; i<=N; i++){
            presum[i] = presum[i-1] + arr[i];
            sum += presum[i];
//            System.out.println(presum[i]);
        }

        System.out.println(sum);

    }
}
