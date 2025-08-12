

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        
        for(int i=0 ; i<N; i++){
            if(arr[i] < M){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
