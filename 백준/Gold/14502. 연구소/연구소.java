

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int N;
    static int M;

    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i=0 ; i<N ;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
             map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        // 빈 공간들의 좌표를 저장
        ArrayList<int[]> emptySpaces = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        // emptySpaces에서 3개를 선택하는 모든 조합
        for(int i=0; i<emptySpaces.size(); i++) {
            for (int j = i + 1; j < emptySpaces.size(); j++) {
                for (int k = j + 1; k < emptySpaces.size(); k++) {

                    int[][] tempMap = copyMap(map);

                    // 좌표 가져오기
                    int[] pos1 = emptySpaces.get(i);
                    int[] pos2 = emptySpaces.get(j);
                    int[] pos3 = emptySpaces.get(k);

                    // 벽 세우기
                    tempMap[pos1[0]][pos1[1]] = 1;
                    tempMap[pos2[0]][pos2[1]] = 1;
                    tempMap[pos3[0]][pos3[1]] = 1;


                    // BFS 실행 후 최댓값 갱신
                    int safeArea = bfs(tempMap);
                    maxSafeArea = Math.max(maxSafeArea, safeArea);


                }
            }
        }

        System.out.println(maxSafeArea);

    }
    // 맵 복사 함수 추가
    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    static int bfs(int[][] map){
        Queue<int[]> queue = new LinkedList<>();

        // 1단계: 모든 바이러스(2) 위치를 큐에 추가
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 2단계: BFS로 바이러스 확산
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 4방향 확산
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크 + 빈 공간(0)인지 체크
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
                    map[nx][ny] = 2; // 바이러스 확산
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 3단계: 안전영역(0) 개수 세기
        int safeArea = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    safeArea++;
                }
            }
        }


        return safeArea;
    }
}
