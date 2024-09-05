import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //값 저장할 3차원 배열 초기화
    static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) {

        //핵심 메모라이제이션(캐시) 로 중복되는 값을 저장해놓는다.
        //buffer 읽으려면 에러처리해야함
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String line = br.readLine();

                String[] input = line.split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);

                int result = w(a, b, c);

                // 입력이 "-1 -1 -1"이면 종료
                if (line.equals("-1 -1 -1")) {
                    break;
                }
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int w(int a,int b, int c){


        // 조건 1: a, b, c 중 하나라도 0 이하이면 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 조건 2: a, b, c 중 하나라도 20보다 크면 w(20, 20, 20) 호출
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 위 2조건으로 보아 아래 계산식에서는 w()함수가 무조건 20보다 낮아진다. 그리고 음수면 1 무조건 반환한다.
        // 그렇다면 위의 절대조건 아래에서 메모라이제이션  w()의 경우의수를 저장하는게 타당하다.
        if(memo[a][b][c] != 0){
            return memo[a][b][c];
        }

        // 조건 3: a < b < c인 경우 , 이 경우가 실질적인 계산부분임으로 메모라이제이션에 저장
        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }else{

            // 나머지 경우
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

        }


        return memo[a][b][c];
    }


}
