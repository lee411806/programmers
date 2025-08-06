

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());



        int[][] arr = new int[N][2];

        for(int i=0 ; i<N;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0 ; j<2; j++){
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]);

        for(int i=1 ; i<N;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            //재사용할지 말지 결정
            if(!pq.isEmpty()&& pq.peek() <= start){
               pq.poll();
            }

            pq.add(end);

        }

        System.out.println(pq.size());

    }
}
