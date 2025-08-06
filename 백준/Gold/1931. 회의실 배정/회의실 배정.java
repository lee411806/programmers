

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] confer = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0 ; j<2;j++){
                confer[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        Arrays.sort(confer, (a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(confer[0][1]);

        int count =1;

        for(int i=1; i<N; i++){

            int start = confer[i][0];
            int end = confer[i][1];

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();      // 이전 회의 제거 (끝남)
                pq.add(end);    // 새 회의 추가
                count++;        // 선택된 회의 개수 증가
            }
        }

        System.out.println(count);

    }


}
