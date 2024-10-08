
/*
문제
모든 행성을 탐사하는데 걸리는 최소 시간
자기자신은 0의 시간 그밖에 나머지 시간은 2차원 행렬로 나타냄

입력 값
행성의 개수 , 현재 행성의 위치
이차원 행렬 (시간)

풀이
1. 데이터 제한이 작음으로 최소이동시간은 플로이드로 적용
2. DFS를 이용해서 경로 탐색 -> 최소 탐사 시간


 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 행성의 개수
        int K = Integer.parseInt(st.nextToken());  // 시작 행성의 위치
        int[][] dist = new int[N][N];  // 행성 간 이동 시간을 저장할 배열

        // 행성 간 이동 시간 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 탐색을 위한 초기 상태 설정
        boolean[] visited = new boolean[N];  // 방문 여부를 체크하는 배열
        visited[K] = true;  // 시작 행성은 방문 처리
        int ans = perm(N, K, dist, visited, 1, K, 0, Integer.MAX_VALUE);  // 순열 탐색 시작

        System.out.println(ans);  // 최소 탐사 시간 출력
    }

    // DFS를 사용한 순열 탐색
    public static int perm(int N, int K, int[][] dist, boolean[] visited, int cnt, int prev, int d, int ans) {
        if (cnt == N) {  // 모든 행성을 탐사했을 때
            return Math.min(ans, d);  // 최소 비용 갱신
        }

        // 모든 행성에 대해 탐사
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;  // 이미 방문한 행성은 제외
            visited[i] = true;  // 행성 방문 처리
            ans = perm(N, K, dist, visited, cnt + 1, i, d + dist[prev][i], ans);  // 다음 행성으로 이동
            visited[i] = false;  // 탐사 후 방문 처리 취소 (백트래킹)
        }

        return ans;  // 최소 탐사 시간을 반환
    }
}


