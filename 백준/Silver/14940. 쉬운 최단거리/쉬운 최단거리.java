

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int N;
   static int M;
   static int[][] map;
   static int[][] answer;

   static int[] dx = {-1,1,0,0};
   static int[] dy = {0,0,-1,1};
   static int twoX;
   static int twoY;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i<N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M; j++){
                map[i][j] = Integer.parseInt(st1.nextToken());
                if(map[i][j] ==2){
                 twoX = i;
                 twoY = j;
                }
            }
        }

        bfs();
        // BFS 후: 방문 안 된 땅들 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && answer[i][j] == 0) {  // 땅인데 방문 안 됨
                    answer[i][j] = -1;  // = 도달 불가
                }
            }
        }
        
        for (int i = 0; i<N; i++) {
            for(int j=0 ; j<M; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{twoX,twoY});
        answer[twoX][twoY] = 0;  // 시작점은 거리 0

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x =current[0];
            int y =current[1];

            for(int i=0 ; i<4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 1 && answer[nx][ny]==0){
                    answer[nx][ny] = answer[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }
}
