import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // BufferedReader를 사용하여 입력값을 받아옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 n(행 수)와 m(열 수) 입력 받기
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        // 붕어빵 배열로 넣기
        String[] arr = new String[n];

        // 각 줄을 배열에 넣음
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();  // BufferedReader로 한 줄씩 입력받기
        }

        // 붕어빵 좌우 반전
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();  // 문자열을 문자 배열로 변환
            int start = 0;
            int end = m - 1;

            while (start < end) {
                // 문자 교환
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }

            // 반전된 문자 배열을 다시 문자열로 변환 후 저장
            arr[i] = new String(chars);
        }

        // 반전된 배열 출력
        for (String line : arr) {
            System.out.println(line);
        }
    }
}