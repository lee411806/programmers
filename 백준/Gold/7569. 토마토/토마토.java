
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M = 0;
    static int N = 0;
    static int H = 0;
    static int[][][] box;

    static int[] dz = {-1,1,0,0,0,0};
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};

    static Queue<Pos> queue= new LinkedList<>();
    static int maxDay;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for(int k=0 ; k<M ; k++){
                    box[i][j][k] = Integer.parseInt(st1.nextToken());
                    if(box[i][j][k] ==1){
                        queue.offer(new Pos(i,j,k,0));

                    }
                }
            }
        }

        bfs();
        if(unripeTomato()) {
            maxDay = -1;  // 익지 않은 토마토가 있으면 -1
        }

        System.out.println(maxDay);
    }

    static void bfs(){
        maxDay =0;

        while(!queue.isEmpty()){
            Pos cur= queue.poll();
            maxDay = Math.max(maxDay, cur.day);

            for(int d=0; d<6; d++){
                int nz = cur.z + dz[d];
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = 1;
                    queue.offer(new Pos(nz, ny, nx, cur.day + 1));
                }
            }
        }
    }

    static boolean unripeTomato(){
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0) {  // 안 익은 토마토 발견!
                        return true;
                    }
                }
            }
        }
        return false;  // 모든 토마토가 익었음
    }

    static class Pos{
        int z;
        int y;
        int x;
        int day;

        Pos(int z, int y, int x, int day){  // 순서를 z, y, x로 변경
            this.z = z;
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
