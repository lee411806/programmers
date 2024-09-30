/*
문제
나이트가 이동하려고 하는 칸으로 몇번 움직이면 이동할 수 있을까?

입력
테스트 케이스 , 체스판 한변의 길이 , (나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸)

풀이
최단 경로의 수 -> bfs -> queue
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //나이트 움직임
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int startY = -1;
    static int endX = -1;
    static int startX = -1;
    static int endY = -1;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {

            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());


            System.out.println(bfs(startX, startY, endX, endY, l));


        }
    }

    public static int bfs(int startX, int startY, int endX, int endY, int l) {

        Queue<int[]> queue = new ArrayDeque<>();

        //방문 좌표 판단
        boolean[][] visited = new boolean[l][l];

        //시작 좌표 넣어줌
        queue.add(new int[]{startX, startY, 0});

        visited[startX][startY] = true;

        //반복 횟수 세기

        while (!queue.isEmpty()) {
            //큐에서 꺼내서 count값까지 넣어줌
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == endX && y == endY) {
                return count;
            }

            // 나이트 움직임
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

            //조건 충족시 방문기록하고 큐에 넣어줌
                if (nx <= l - 1 && ny <= l - 1 && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count+1});
                }


            }
        }
        return -1;
    }

}
