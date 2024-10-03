/*
문제
로봇 청소기가 정해진 위치에서 작동을 시작한 후 멈출 때 까지 청소하는 칸의 개수를 출력

입력
방의 크기 n,m
좌표 (r,c) , 방향 d
방의 상태

풀이
1. 입력 값 다 받아서 초기위치 r c , 방향 d , 방 행렬 설정
2. 청소 시뮬레이션 메서드 만들어서 조건 넣어줌
3. 현재 위치 , 방향에서 동서남북 청소확인 -> 있으면 while반복문 으로 돌아가서 다치 처음부터 시뮬레이션
4. 현재 위치 , 방향에서 동서남북 청소 안되어있으면 -> 후진시도하가 벽이 나오면 while문 탈출

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0}; // 문제에서 주어진 방향 코드 북, 동, 남, 서 방향 인덱스와 맞춤
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        int d = Integer.parseInt(st1.nextToken());

        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int result= clean(r,c,d,room,N,M);
        System.out.println(result);
    }

    public static int clean(int r, int c, int d, int[][] room, int N, int M) {

        int result = 0;

        while (true) {
            //1. 현재 칸 청소
            if (room[r][c] == 0) {
                room[r][c] = 2;
                result++;
            }

            //2현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우

            //주변 4칸중 청소할수 있나?
            boolean f = false;

            for (int i = 0; i < 4; i++) {
                //d반시계 방향 설정
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                //청소되지 않는 청소안되어있으면
                if(nr>=0 && nc>=0 && nr < N && nc < M && room[nr][nc] == 0){
                    r = nr;
                    c = nc;
                    f = true;
                    break;
                }
            }


            //3. 청소 할 수 없으면 자연스럽게 3번을 내려옴-> 1 후진 시도 ,2 후진할 수 없다면 작동 멈춤
            if(f == false){
                int back = (d+2) % 4;
                int nr = r + dr[back];
                int nc = c + dc[back];

                //후진
                // 헷갈림 방지  1은 벽이다.
                if(nr>=0 && nc>=0 && nr < N && nc < M && room[nr][nc] != 1){
                    r = nr;
                    c = nc;
                }else{
                    break;
                }
            }
        }

        return result;
    }


}







