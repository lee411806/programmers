/*
문제
수빈이는 걷거나 순간이동을 할 수 있다.
순간이동 2 * x , 걸음 x - 1, x + 1
입력
수빈이가 있는 위치 , 동생이 있는 위치

풀이
최단거리 -> bfs

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {

        //입력 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subinN = Integer.parseInt(st.nextToken());
        int brotherN = Integer.parseInt(st.nextToken());

        System.out.println(bfs(subinN, brotherN));

    }

    public static int bfs(int subinN, int brotherN) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[]{subinN, 0});

        visited[subinN] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int sx = current[0];
            int count = current[1];
            int teleport = sx * 2;

            if (sx == brotherN) {
                return count;
            }

            if (teleport < 100001 && !visited[teleport]) {
                queue.add(new int[]{teleport, count + 1});
                visited[teleport] = true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = sx + dx[i];
                if(nx>=0 && nx < 100001 && !visited[nx]) {
                    queue.add(new int[]{nx, count + 1});
                    visited[nx] = true;
                }
            }
        }
        return -1;
    }

}


