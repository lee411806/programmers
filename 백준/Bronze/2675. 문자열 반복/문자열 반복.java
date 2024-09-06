import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 반복수
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");

            // 문자 반복 수
            int rp = Integer.parseInt(arr[0]);

            // 문자 -> 문자열
            String S = arr[1];  // 두 번째 요소를 문자열로 사용

            // 새로운 StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // 문자를 반복하여 StringBuilder에 추가
            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < rp; k++) {
                    sb.append(S.charAt(j));  // char을 하나씩 추가
                }
            }

            // StringBuilder 내용 출력
            System.out.println(sb.toString());
        }


    }
}