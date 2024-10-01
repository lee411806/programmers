/*
문제
최대 10000개의 섬(n)
중량 제한 -> 가중치 , 중량제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너지게됨, --> 제한조건 중량치가 제한크기보다 같거나 커야한다.
한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값

입력 값
섬 n , 다리 m개
a,b의 섬에서 중량제한이 c (서로같은 두 섬 사이에 여러개 다리 존재 가능 , 양방향)
공장이 위치해 있는 서로다른 두 섬

풀이
인접행렬로 가중치 그래프 구현시 10000 * 10000 행렬 만들어야 함으로
1. 인접리스트을 배열로 만들어서 구현
2. 시작섬으로 인덱스타고 3번섬까지의 가중치 출력
3. 무게 범위가 큼으로 시간복잡도가 작은 O(logn)으로 원하는값 탐색 가능
4. 이분 탐색으로 mid 이상의 다리만 반복 찾기(bfs)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        // 섬의 개수 n, 다리의 개수 m
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        // 그래프 구현 (인접 리스트로 표현)
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 시작섬 a, 끝섬 b, 가중치 c (중량 제한)
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c}); // 섬 a -> 섬 b (중량 제한 c)
            graph[b].add(new int[]{a, c}); // 섬 b -> 섬 a (양방향)
        }

        // 공장이 위치한 두 섬 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());

        // 이분 탐색을 위한 low와 high 설정
        int low = 1;
        int high = 1000000000;
        int answer = 0;

        // 이분 탐색
        while (low <= high) {
            int mid = (low + high) / 2;

            // BFS로 중량 mid가 가능한지 체크
            if (bfs(factory1, factory2, mid, n, graph)) {
                answer = mid;  // 가능한 경우 정답 갱신
                low = mid + 1; // 더 큰 중량 탐색
            } else {
                high = mid - 1; // 더 작은 중량 탐색
            }
        }

        // 결과 출력
        System.out.println(answer);
    }

    // BFS 함수 (중량이 가능한지 확인)
    public static boolean bfs(int factory1, int factory2, int mid, int n, List<int[]>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        // 시작 섬 factory1에서 시작
        queue.add(factory1);
        visited[factory1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목적지에 도달한 경우
            if (current == factory2) {
                return true;
            }

            // 현재 섬에서 연결된 다른 섬 탐색
            for (int[] next : graph[current]) {
                int nextIsland = next[0];
                int weightLimit = next[1];

                // 아직 방문하지 않았고, 중량이 mid 이상인 다리만 사용
                if (!visited[nextIsland] && weightLimit >= mid) {
                    visited[nextIsland] = true;
                    queue.add(nextIsland);
                }
            }
        }

        // 목적지에 도달할 수 없는 경우
        return false;
    }
}



