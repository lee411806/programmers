import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
1.A성적이 다른지원자 B의 성적에 비해 둘다 떨어진다면 A선발되지 않는다. -> 둘 중 하나를 오름차순으로 정렬한 후에 비교
2. 주의할 점 테스트 케이스 20 ㅡ 숫자 100000 -> 시간복잡도 o(n)2되면 4조 ;; => 40초가 걸림으로 2초안에 풀수있는 정렬법 필요함
풀이

 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1] = b;
            }


            // 면접 성적 비교를 통해 선발 가능한 인원 수 계산
            int passCount = 1;  // 서류 1등은 무조건 합격
            int bestInterviewRank = arr[0];  // 서류 1등의 면접 성적

            for (int i = 1; i < n; i++) {
                if (arr[i] < bestInterviewRank) {  // 면접 성적이 더 좋은 경우
                    passCount++;  // 선발 인원 증가
                    bestInterviewRank = arr[i];  // 최상위 면접 성적 갱신
                }
            }

            System.out.println(passCount);
            testCase--;
        }
    }
}
