import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
플레이어는 각 레벨을 클리어하면서 점수를 얻는데 여기서 에러남
특정 레벨의 수 감소, 1감소 1번
레벨별 알맞은 점수값을 가지게 하여라

풀이
뒤에서 부터 비교하며 감소시키면 됨
 */
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
//            System.out.println(levels[i]);
        }

        //결과 값 result, end값 pointer를 이용해 맨뒤부터 비교
        int end = N - 2;
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            //end가 -1이 되면 break;
            if (end == -1) break;

            if (levels[end] >= levels[i]) {
                while (levels[end] >= levels[i]) {
                    levels[end]--;
                    result++;
                }
            }
            end--;
        }

        System.out.println(result);
    }
}
