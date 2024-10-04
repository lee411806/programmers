/*
문제
상자의 크기가 뒤에있는 상자보다 크기가 작으면 앞의 상자를 뒤에 넣을 수 있다.
한번에 넣을 수 있는 상자의 개수
단 넣는 기회는 한번임으로 최대한 많은 상자를 한번에 넣어야한다.

풀이
1.가장 길게 증가하는 부분 수열 -> LIS(최장 증가 수열)
2. DP로 최장 증가 수열 기록하면서 배열 돌림
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberLen = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 값 처리
        int[] arr = new int[numberLen];
        for (int i = 0; i < numberLen; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 동적 lis 선언
        int[] lisDP = new int[numberLen];

        // LIS 계산 및 결과 출력
        System.out.println(lis(lisDP, arr, numberLen));
    }

    public static int lis(int[] lisDP, int[] arr, int numberLen){

        // 숫자가 하나만 있어도 lis가 1이니 1로 채워넣기
        Arrays.fill(lisDP, 1);

        // LIS 계산
        for (int i = 1; i < numberLen; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lisDP[i] = Math.max(lisDP[i], lisDP[j] + 1);
                }
            }
        }


//        for(int temp: lisDP){
//            System.out.print(temp+" ");
//        }
//
        // LIS 배열에서 가장 큰 값 반환
        int result  = Integer.MIN_VALUE;
        for (int temp : lisDP) {
            result= Math.max(result, temp);
        }

        return result;
    }
}






