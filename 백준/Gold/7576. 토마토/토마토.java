

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int M;
   static int N;

   static int[][] map;
   static int[] dx = {-1,1,0,0};
   static int[] dy = {0,0,-1,1};

   static Queue<int[]> queue =new LinkedList<>();
   static int days =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i=0 ;i<M; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
               map[i][j] = Integer.parseInt(st1.nextToken());
               if(map[i][j] == 1){
                    queue.add(new int[]{i,j});
               }
            }
        }

        bfs();

        boolean tomatoRipen = false;
        for(int i=0 ;i<M && !tomatoRipen; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){
                    tomatoRipen = true;
                    break;
                }
            }
        }

        if(tomatoRipen == true){
            System.out.println(-1);
        }else{
            System.out.println(days);
        }


    }

    static void bfs(){

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size;i++){
                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];

                for(int j=0; j<4;j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny] ==0){
                        map[nx][ny] =1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }

            if(!queue.isEmpty()){
                days++;
            }

        }

    }
}
