/*
문제
도시 1~N
도로 M개 단방향
도로의 거리 모두 1
특정한 도시 x 에서 k만큼 다면 도달할 수 있는 도시번호들 출력

입력
도시의 개수 N , 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X

풀이
최단거리 k거리로 갈 수 있는 모든 도시 -> bfs
인접행렬로 그래프를 나타내기에는 도시가 너무 많은 -> 인접 리스트
bfs로 최단거리를 구하는 알고리즘에서 최단거리가 2일때 나오는 도시를 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static List<List<Integer>> cityGraph = new ArrayList<>();
    static Set<Integer> resultCity = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        //그래프에 접점 추가
        for (int i = 0; i < N + 1; i++) {
            cityGraph.add(new ArrayList<>());
        }

        //단방향 선 추가
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());  //출발방향
            int y = Integer.parseInt(st1.nextToken());  //도착방향
            cityGraph.get(x).add(y);
        }

        // --> 그래프 완성
        bfs();

        List<Integer> resultSet = new ArrayList<>(resultCity);
        Collections.sort(resultSet);
        for(int temp : resultSet) {
            System.out.println(temp);
        }

    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        //거리가 k인 도시가 없을 때
        boolean found = false;

        queue.add(new int[]{X, 0}); // 현재 x번 도시 0거리의 상태로 탐색

        boolean[] visited = new boolean[N + 1];
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCity = current[0];
            int currentDistance = current[1];

            //현재 도시까지의 거리가 k인 경우 도시 추가
            if (currentDistance == K) {
                resultCity.add(currentCity);
                found = true;
            }

            for (int nextCity : cityGraph.get(currentCity)) {
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.add(new int[]{nextCity, currentDistance + 1});
                }
            }


        }
        if(!found){
            System.out.println(-1);
        }
    }

}
