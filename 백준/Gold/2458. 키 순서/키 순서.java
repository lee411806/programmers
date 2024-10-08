
/*
문제
N명의 학생들의 키는 다르다고 가정하고 서로의 키를 비교하는 결과만 주어졌다.
키의 순위를 알 수 있는 학생은?

입력 값
학생들의 수 , 두 학생키를 비교한 횟수

풀이
1. 방향 그래프 -> 인접행렬
2.  bfs로 N-1 = 작거나 큰 학생들의 수 이면 몇 순위 인지 알 수 있다.
3. 자신보다 큰 학생수 ,작은 학생수 count합한거 5이상이면 알 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        while(M-- > 0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            graph[a][b] = 1;

        }

        // 플로이드-워셜 알고리즘 적용 (간접적인 비교도 모두 고려)
        for (int k = 1; k <= N; k++) { // 경유하는 학생
            for (int i = 1; i <= N; i++) { // 출발 학생
                for (int j = 1; j <= N; j++) { // 도착 학생
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1; // i번 학생이 j번 학생보다 작다
                    }
                }
            }
        }

        int result = 0;

        // 각 학생에 대해 자신보다 큰 학생과 작은 학생 수 계산
        for (int i = 1; i <= N; i++) {
            int largerCount = 0;
            int smallerCount = 0;

            // i번 학생보다 큰 학생과 작은 학생을 각각 계산
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) { // i번 학생이 j번 학생보다 작다
                    largerCount++;
                }
                if (graph[j][i] == 1) { // j번 학생이 i번 학생보다 작다
                    smallerCount++;
                }
            }

            // 자신보다 작은 학생 + 큰 학생 >= N - 1 이면 순서를 알 수 있음
            if (largerCount + smallerCount == N - 1) {
                result++;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
    
}




