import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    /*
    입력 값 : 가로 세로 길이의 목장 , 울타리, 양, 늑대
    문제 : 울타리 안에 살아남는 양과 늑대의 수 계산
           -> 양과 늑대 중 하나가 더 많으면 해당 동물이 살아남음.

    풀이:
    1. BFS 사용하여 각 구역을 넓게 탐색
    2. 모든 지점에서 상하좌우 이동, 울타리를 만나면 다른 방향으로 이동
    3. 방문한 곳은 건너뛰기
    4. 탐색이 끝난 후 양과 늑대의 수를 비교하여 결과 도출
    */

    static char[][] fence;  // 목장 배열 (울타리, 양, 늑대 정보)
    static boolean[][] visited;  // 방문 여부 확인 배열
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 x축 이동
    static int[] dy = {0, 0, -1, 1};  // 상하좌우 y축 이동
    static int leftSheep = 0;  // 최종 남은 양의 수
    static int leftWolves = 0;  // 최종 남은 늑대의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 입력 줄에서 row와 col 값 추출
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);  // 목장의 세로 크기
        int col = Integer.parseInt(input[1]);  // 목장의 가로 크기

        fence = new char[row][col];  // 목장 배열 초기화
        visited = new boolean[row][col];  // 방문 확인 배열 초기화

        // 목장 영역 입력 받기
        for (int i = 0; i < row; i++) {
            fence[i] = br.readLine().toCharArray();  // 목장 각 줄을 입력받아 배열로 저장
        }

        // 모든 지점에서 BFS 탐색 시도
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 양 또는 늑대가 있는 지점이면서 방문하지 않은 경우 BFS 시작
                if ((fence[i][j] == 'k' || fence[i][j] == 'v') && !visited[i][j]) {
                    bfs(i, j);  // 해당 좌표에서 BFS 탐색 시작
                }
            }
        }

        // 최종 남은 양과 늑대 수 출력
        System.out.println(leftSheep + " " + leftWolves);
    }

    // BFS 탐색 함수
    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();  // BFS에 사용할 큐 선언

        // 시작 좌표 큐에 추가하고 방문 표시
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int sheep = 0;  // 현재 구역의 양 수
        int wolves = 0;  // 현재 구역의 늑대 수

        // 시작점이 양인지 늑대인지 확인
        if (fence[i][j] == 'k') {
            sheep++;  // 양인 경우 양 카운트 증가
        } else if (fence[i][j] == 'v') {
            wolves++;  // 늑대인 경우 늑대 카운트 증가
        }

        // 큐에서 좌표를 꺼내서 상하좌우 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // 큐에서 현재 위치를 꺼냄
            int x = current[0];  // 현재 위치의 x 좌표
            int y = current[1];  // 현재 위치의 y 좌표

            // 상하좌우 방향으로 이동하며 탐색
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];  // 새로운 x 좌표
                int ny = y + dy[k];  // 새로운 y 좌표

                // 범위를 벗어나거나 울타리이거나, 이미 방문한 경우는 건너뜀
                if (nx < 0 || ny < 0 || nx >= fence.length || ny >= fence[0].length || visited[nx][ny] || fence[nx][ny] == '#') {
                    continue;  // 해당 조건에 걸리면 다른 방향 탐색
                }

                visited[nx][ny] = true;  // 새로운 좌표 방문 표시
                queue.add(new int[]{nx, ny});  // 큐에 추가하여 탐색 지속

                // 새로 방문한 곳이 양인지 늑대인지 확인하고 카운트
                if (fence[nx][ny] == 'k') {
                    sheep++;  // 양인 경우 양 카운트 증가
                } else if (fence[nx][ny] == 'v') {
                    wolves++;  // 늑대인 경우 늑대 카운트 증가
                }
            }
        }

        // 탐색이 끝난 후, 양과 늑대의 수를 비교하여 결과 반영
        if (sheep > wolves) {
            leftSheep += sheep;  // 양이 더 많으면 늑대가 모두 잡아먹힘
        } else {
            leftWolves += wolves;  // 늑대가 더 많으면 양이 잡아먹힘
        }
    }
}
