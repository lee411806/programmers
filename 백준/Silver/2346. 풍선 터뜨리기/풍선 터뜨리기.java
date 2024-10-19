
/*
문제
1. 풍선들 원형 배치
2. 항상 1번 풍선을 먼저 터트림
3. 풍선 속에 있는 종이에 적힌 숫자만큼 이동해서 풍선 터트림
이동 규칙 : 종이에 적힌 숫자가 양수일 경우 오른쪽(시계방향) 으로 이동
종이에 적힌 숫자가 음수일 경우 왼쪽(반시계) 방향으로 이동

입력 값
풍선수
안에 적힌 숫자

풀이
첫번째 꺼내고 꺼낸 부호 , 숫자 만큼 데크 회전

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 입력값 받기
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 입력: 풍선의 개수 N
        int N = scanner.nextInt();

        // 두 번째 입력: 각 풍선에 적힌 종이의 값들
        int[] papers = new int[N];
        for (int i = 0; i < N; i++) {
            papers[i] = scanner.nextInt();
        }

        // (풍선 번호, 풍선 안의 숫자) 형태로 덱에 저장
        Deque<int[]> balloons = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            balloons.addLast(new int[]{i + 1, papers[i]}); // (번호, 종이에 적힌 숫자)
        }

        List<Integer> result = new ArrayList<>(); // 터진 풍선의 순서를 저장할 리스트

        // 처음에는 1번 풍선을 터뜨린다
        int[] currentBalloon = balloons.pollFirst();
        result.add(currentBalloon[0]);  // 터뜨린 풍선 번호 저장

        // 그 다음부터는 남은 풍선을 순서대로 터뜨린다
        while (!balloons.isEmpty()) {
            int move = currentBalloon[1];  // 종이에 적힌 숫자

            // 이동 (양수면 오른쪽, 음수면 왼쪽으로 회전)
            if (move > 0) {
                // 오른쪽으로 move-1 만큼 이동 (이미 하나 터뜨렸으므로)
                for (int i = 0; i < move - 1; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                // 왼쪽으로 move 만큼 이동
                for (int i = 0; i < -move; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }

            // 풍선을 터뜨리고 결과에 추가
            currentBalloon = balloons.pollFirst();
            result.add(currentBalloon[0]);
        }

        // 결과 출력
        for (int balloon : result) {
            System.out.print(balloon + " ");
        }
    }
}





