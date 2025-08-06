

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        //거리 입력
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] distance = new int[N-1];

        for(int i=0; i < N-1 ; i++){
            distance[i] = Integer.parseInt(st1.nextToken());
        }

        //주유소 입력
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] gasStore = new int[N];

        for(int i=0; i < N ; i++){
            gasStore[i] = Integer.parseInt(st2.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int cost = 0;

        for(int i=0; i < N-1 ; i++){

            if(gasStore[i] < min){
                min = Math.min(min, gasStore[i]);
            }

            cost += min * distance[i];

        }

        System.out.println(cost);
    }
}
