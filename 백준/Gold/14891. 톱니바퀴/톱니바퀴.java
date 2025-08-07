

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    static char[][] gears = new char[4][8]; // 4개의 톱니바퀴, 각 8칸

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            gears[i] = br.readLine().toCharArray(); // 문자열 → char[]로 저장
        }

        int K = Integer.parseInt(br.readLine()); // 회전 횟수

        // 2. 회전 명령 처리
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 0-based
            int dir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계

            int[] directions = new int[4]; // 각 톱니의 회전 방향 저장
            directions[gearNum] = dir;

            // 왼쪽 전파
            for (int i = gearNum; i > 0; i--) {
                if (gears[i][6] != gears[i - 1][2]) {
                    directions[i - 1] = -directions[i];
                } else break;
            }

            // 오른쪽 전파
            for (int i = gearNum; i < 3; i++) {
                if (gears[i][2] != gears[i + 1][6]) {
                    directions[i + 1] = -directions[i];
                } else break;
            }

            // 실제 회전 수행
            for (int i = 0; i < 4; i++) {
                if (directions[i] != 0) {
                    rotate(gears[i], directions[i]);
                }
            }
        }

        // 3. 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == '1') score += (1 << i); // 2^i
        }

        System.out.println(score);
    }
    static void rotate(char[] gear, int dir) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : gear) dq.addLast(c);

        if (dir == 1) { // 시계 방향
            dq.addFirst(dq.pollLast());
        } else if (dir == -1) { // 반시계 방향
            dq.addLast(dq.pollFirst());
        }

        // 다시 char[]로 되돌리기
        int i = 0;
        for (char c : dq) {
            gear[i++] = c;
        }
    }


}