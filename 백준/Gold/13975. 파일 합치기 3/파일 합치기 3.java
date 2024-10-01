/*
문제
두개 씩 합쳐 최종파일을 만드는데 필요한 최소비용

풀이
올림차순 정렬 -> 작은 것 부터 더해줌

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            //폴더의 수
            int dc = Integer.parseInt(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>();
            //폴더를 배열에 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < dc; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            // 두수를 더하면서 계속 우선순위 큐에 넣는다.
            long result = 0;
            long temp = 0;
            //큐가 2개이상이어야지 더하기 가능
            while (queue.size() > 1) {
                //수가 하나 남았을 때 결과값 넣기
                temp = queue.poll() + queue.poll();
                result += temp;
                queue.add(temp);
            }
            System.out.println(result);
        }


    }

}



