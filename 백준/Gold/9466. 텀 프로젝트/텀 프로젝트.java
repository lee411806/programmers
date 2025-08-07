

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[] choice;
    static boolean[] visited;
    static boolean[] finished;
    static int teamCount = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            choice = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            teamCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            // 각 학생에서 DFS 시작
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - teamCount);
        }

    }

    static void dfs(int current) {
        visited[current] = true;
        int next = choice[current];

        if(!visited[next]) {
            // 아직 방문하지 않은 곳이면 계속 탐색
            dfs(next);
        } else if(!finished[next]) {  // ← 이 조건!
            // 사이클 카운트하기
            int temp = next;
            while(true) {
                teamCount++;
                temp = choice[temp];
                if(temp == next) break;
            }
        }

        finished[current] = true;
    }
}