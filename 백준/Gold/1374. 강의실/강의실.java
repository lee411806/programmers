
/*
문제
N개의 강의, 최대한 적은 수의 강의실을 이용하여 모든 강의가 이루어진다.
종료시간 시작시간 겹치는건 됀찮다.
최소 강의실 수 출력

입력값
강의의 개수
강의 번호, 강의 시작시간, 종료 시간

풀이
1. 강의 시간을 인덱스로 놓고 카운팅 해주려했는데 강의종료시간이 10억?..
2. 어차피 시간 겹치면 강의실 늘려야되지만 강의실 안에 시간표를 앞에서 부터 꽉채울 수록 유리
3. 2차원 배열 시작시간 기준으로 정렬 , 우선순위큐에 종료시간 넣기
4. 다음 시작시간과 비교하여 겹치면 우선순위 큐에 종료시간 넣기 -> 우선순위 큐 사이즈가 최소 강의실 개수
5. 안겹치면 queue안에있는 최소값 꺼내기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 강의의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 강의 배열 선언
        int[][] lecture = new int[N][2];

        // 강의 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lecNum = Integer.parseInt(st.nextToken());  // 강의 번호는 사용하지 않으므로 무시
            int start = Integer.parseInt(st.nextToken());   // 시작 시간
            int end = Integer.parseInt(st.nextToken());     // 종료 시간
            lecture[i][0] = start;  // 시작 시간 저장
            lecture[i][1] = end;    // 종료 시간 저장
        }

        // 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(lecture, (a, b) -> a[0] - b[0]);

        // 우선순위 큐 (종료 시간을 기준으로 관리)
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.add(lecture[0][1]);  // 첫 번째 강의의 종료 시간을 큐에 추가

        // 최소 강의실 수 계산
        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 강의의 종료 시간과 비교
            if (endTime.peek() <= lecture[i][0]) {
                endTime.poll();  // 종료된 강의실을 큐에서 제거
            }
            // 새로운 강의의 종료 시간을 큐에 추가
            endTime.add(lecture[i][1]);
        }

        // 우선순위 큐의 크기가 필요한 최소 강의실 수
        System.out.println(endTime.size());
    }
}

