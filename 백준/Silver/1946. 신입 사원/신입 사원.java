import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int n = Integer.parseInt(br.readLine());

            // 지원자 정보 저장 (서류 성적, 면접 성적)
            int[][] applicants = new int[n][2];

            // 입력 처리
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int paperRank = Integer.parseInt(input[0]);
                int interviewRank = Integer.parseInt(input[1]);
                applicants[i][0] = paperRank;  // 서류 성적
                applicants[i][1] = interviewRank;  // 면접 성적
            }

            // 서류 성적 기준 오름차순 정렬
            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            // 면접 성적 비교를 통해 선발 가능한 인원 수 계산
            int passCount = 1;  // 서류 1등은 무조건 합격
            int bestInterviewRank = applicants[0][1];  // 서류 1등의 면접 성적

            for (int i = 1; i < n; i++) {
                if (applicants[i][1] < bestInterviewRank) {  // 면접 성적이 더 좋은 경우
                    passCount++;  // 선발 인원 증가
                    bestInterviewRank = applicants[i][1];  // 최상위 면접 성적 갱신
                }
            }

            System.out.println(passCount);
            testCase--;
        }
    }
}
