/*
문제
연결되어 있으면 바이러스 걸리고 안되어 있으면 안걸림

입력 값
컴퓨터의 수
직접 연결되는 컴퓨터 쌍의 수
연결되어있는 번호 쌍

풀이
1.바이러스에 걸리지 않은 모든 컴퓨터의 수 -> 모든 (dfs)
2.인접행렬 -> 연결되어있는 컴퓨터 나타냄
3. 배열 1차원에서 연결되어있다는 조건을 만족하면 재귀 -> 2차원 인덱스가 1차원 인덱스로 가서 다시비교
4. 방문한 컴퓨터 수 세면 됨
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] computerBoard;
    static int computerN;
    static int virusCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerN = Integer.parseInt(br.readLine());

        //인덱스로 계산할건데 컴퓨터는 1부터 시작
        computerBoard = new int[computerN+1][computerN+1];

        // 연결된 쌍의 수 --> 반복문 돌릴 때 이중 for문 사용안 할 수 있게됨
        int couple = Integer.parseInt(br.readLine());

        visited = new boolean[computerBoard.length];

        //연결된 그림 -> 행렬로 나타냄
        for(int i = 0; i < couple; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            computerBoard[x][y] = 1;
            computerBoard[y][x] = 1; //무방향임으로 둘다 저장
        }

        dfs(1);

        System.out.println(virusCount);
    }

    public static void dfs(int start){

            visited[start] = true;

            for(int i = 1; i <= computerN; i++){
                if(!visited[i] && computerBoard[start][i] == 1){
                    virusCount++;
                    dfs(i);
                }
            }


    }
}
