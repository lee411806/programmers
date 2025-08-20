

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] connect;
    static boolean[] visited;
    static int M;

    static int count =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        connect = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());  // 매번 새 줄!
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());

            connect[u].add(v);
            connect[v].add(u);

        }

        visited = new boolean[N+1];

        for (int i = 1; i <=N; i++) {
            if(!visited[i]){
                count++;
                dfs(i);
            }

        }
        System.out.println(count);
    }

    static void dfs(int start){
        visited[start] = true;

        for(int neighbor : connect[start]){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}
