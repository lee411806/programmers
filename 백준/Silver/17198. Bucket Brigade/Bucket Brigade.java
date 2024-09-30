/*
문제
소들이 호수에서 헛간으로 물을 퍼나를 수 있는 최단 경우의 수

입력
농장 배치표

풀이
최단 경우의 수 -> bfs

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1}; // 상, 우, 하, 좌
    static int bx; // 소의 x 좌표
    static int by; // 소의 y 좌표
    static int Lx; // 호수의 x 좌표
    static int Ly; // 호수의 y 좌표
    static String[][] strArr = new String[10][10]; // 농장 상태 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 농장 배열에 넣기
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (line.charAt(j) == 'B') {  // 소의 위치 저장
                    bx = i;
                    by = j;
                } else if (line.charAt(j) == 'L') {  // 호수 위치 저장
                    Lx = i;
                    Ly = j;
                }
                strArr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // BFS 호출
        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{bx, by, 0});  // {소의 x, 소의 y, 초기 거리 0}
        boolean[][] visited = new boolean[10][10];  // 방문 처리 배열
        visited[bx][by] = true;  // 소의 시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // 큐에서 현재 위치와 거리를 꺼냄
            int cx = current[0];  // 현재 x 좌표
            int cy = current[1];  // 현재 y 좌표
            int distance = current[2];  // 현재까지의 거리

            // 만약 호수 위치에 도달했다면, 거리 출력 후 종료
            if (cx == Lx && cy == Ly) {
                System.out.println(distance - 1);
                return;  // 프로그램 종료
            }

            // 상, 하, 좌, 우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];  // 다음 x 좌표
                int ny = cy + dy[i];  // 다음 y 좌표

                // 유효 범위 내에 있고, 방문하지 않았으며, 돌이 아닌 경우
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !visited[nx][ny] && !strArr[nx][ny].equals("R")) {
                    visited[nx][ny] = true;  // 방문 처리
                    queue.add(new int[]{nx, ny, distance + 1});  // 큐에 새로운 위치와 거리 추가
                }
            }
        }
    }
}

