import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int N = 0;
    static int L = 0;
    static int R = 0;
    static int[][] nation;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nation = new int[N][N];

        for(int i=0; i < N ; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                nation[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int days = 0;

        while(true){
            // 하루 연합 형성 방문 체크
            visited = new boolean[N][N];
            boolean moved = false;

            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if(!visited[i][j]){
                        List<Pos> union = bfs(i,j);
                        if(union.size() >1){
                            moved = true;
                            movePopulation(union);
                        }
                    }
                }
            }

            if(!moved)break;
            days++;
            }

        System.out.println(days);
    }



    static List<Pos> bfs(int x, int y){

        Queue<Pos> queue = new LinkedList<>();
        List<Pos> union = new ArrayList<>();

        queue.offer(new Pos(x,y));
        union.add(new Pos(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int d=0; d<4 ; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx >=0 && nx<N && ny>=0 && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(nation[cur.x][cur.y] - nation[nx][ny]);
                    if (diff >= L && diff <=R){
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx,ny));
                        union.add(new Pos(nx,ny));
                    }
                }
            }
        }
        return union;
    }

    static void movePopulation(List<Pos> union){
        int total =0;

        for(Pos p: union){
            total += nation[p.x][p.y];
        }

        int avg = total /union.size();

        for(Pos p : union){
            nation[p.x][p.y] = avg;
        }
    }

    static class Pos{
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

