import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    //숫자판 -> 배열
    static int[][] board = new int[5][5];

    // 경우의 수 중복 방지 set 생성
    static Set<String> set = new HashSet<>();

    //방향 설정
    static int[] dx = {0, 0, -1, 1};  // x축 이동: 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};  // y축 이동: 상, 하, 좌, 우


    public static void main(String[] args) throws IOException {

        /*
        입력 값 :숫자 판
        문제 : 6자리가 될 수 있는 모든 경우의 수를 구할 것
        풀이
        1.단순 조건 , 모든 경우의 수 -> dfs -> 재귀
        2.인덱스로 좌표이동, 크기 고정되어있음 -> 배열
        3.6자리의 수 중복 방지 -> Set 활용
        4.좌표 움직임 -> 재귀, 바운더리, 상하좌우 이동
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //숫자판 값 넣기
        for (int i = 0; i < 5; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        //모든 위치에 있어서 재귀 함수 호출 --> 모든 자리에 있어 6자리의 수 만들 수 있는 경우의 수 만듬
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "", 0);
            }

        }

        System.out.println(set.size());

    }

    static void dfs(int x, int y, String number, int numberCount) {
        //6자리수가 되면 반환
        if (numberCount == 6) {
            set.add(number);
            return;
        }

        //상하좌우 이동하고 바운더리 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            // 바운더리 밖이면 재귀함수 호출하지 않고 방향바꿈
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }


            dfs(nx, ny, number + board[nx][ny], numberCount + 1);
        }

    }

}
