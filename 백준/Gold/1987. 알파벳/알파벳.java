import java.io.*;
import java.util.*;

public class Main{

    static int R=0;
    static int C=0;
    static char[][] board;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static boolean[] usedAlpha = new boolean[26];
    static int maxCount = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = str.charAt(j);
            }
        }

        usedAlpha[board[0][0] - 'A'] = true;
        dfs(0,0,1);

        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count){
        maxCount = Math.max(maxCount,count);

        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx>=0 && nx<R && ny>=0 && ny<C){
                int alphaIndex = board[nx][ny] - 'A';
                if(!usedAlpha[alphaIndex]){
                    usedAlpha[alphaIndex] = true;
                    dfs(nx,ny,count+1);
                    usedAlpha[alphaIndex] = false;
                }

            }
        }
    }

}
