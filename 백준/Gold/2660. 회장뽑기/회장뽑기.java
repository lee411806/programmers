
/*
문제
각 회원은 다른 회원들과 가까운 정도에 따라 점수를 받게 됨
친구는 1단계 연결이고, 친구의 친구는 2단계 연결, 친구의 친구의 친구는 3단계 연결

입력 값
회원의 수
두 회원의 번호 -> 서로 친구임을 나타냄

풀이
1. 거리=친밀도 측정
2. 점수가 가장 적으면 회장 -> 친구사이의 최단 거리 -> bfs
3. ++ 플로이드 알고리즘 , 다익스트라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        while(a!= -1 || b!= -1){
            graph[a][b] = 1;
            graph[b][a] = 1;
            //다음 입력을 받음

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        // 인접 행렬 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
//                System.out.print(graph[i][j] + " ");
            }
//            System.out.println();
        }

        //각 회원에 점수를 저장할 배열
        int[] scores = new int[N + 1];


        //BFS를 이용하여 각 회원의 점수를 계산해서 가장 적은 회원 구함

        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            scores[i] = bfs(i,N,graph);
            minScore = Math.min(minScore,scores[i]);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        Collections.sort(candidates);

        // 결과 출력
        System.out.println(minScore + " " + candidates.size());
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }


    }

    public static int bfs(int start, int N, int[][] graph){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1]; //각 회원까지의 거리를 저장함

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){

            int current = queue.poll();

            for(int i=1 ; i<=N ; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    distance[i] = distance[current] + 1;
                }
            }



        }
        // 최대 거리가 회원의 점수
        int maxDistance = Integer.MIN_VALUE;
        for(int i=1 ; i<=N ; i++){
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        return maxDistance;
    }
}




