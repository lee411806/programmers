
/*
문제
1. 표가 있는데 모든 수는 자신의 한 칸 위에있는 수보다 크다.

입력 값
풍선수
안에 적힌 숫자

풀이
우선순위큐 내림차순으로 만들고 5번째 수?

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++) {
            pq.poll();
        }
        System.out.println(pq.peek());

    }
}





