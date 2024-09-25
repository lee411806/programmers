import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 버퍼로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 받기: N과 K
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // N명의 사람
        int K = Integer.parseInt(st.nextToken()); // K번째 제거

        // 큐 생성 및 초기화
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i); // 1부터 N까지 큐에 넣기
        }

        // 결과를 담을 StringBuilder (출력 형식 맞추기)
        StringBuilder result = new StringBuilder();
        result.append("<");

        int count = 0;

        // 요세푸스 순열 처리
        while (!queue.isEmpty()) {
            // K번째 사람을 찾아서 제거
            for (int i = 1; i < K; i++) {
                // K번째가 아닌 사람은 다시 큐에 넣음
                queue.add(queue.poll());
            }
            // K번째 사람은 제거하고 출력
            result.append(queue.poll());

            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }

        result.append(">");
        System.out.println(result.toString());
    }
}
