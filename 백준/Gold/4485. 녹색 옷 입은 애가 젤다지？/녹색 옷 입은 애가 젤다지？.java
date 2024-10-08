
/*
문제
잃는 금액을 최소로 하여 동굴 건너편 까지 이동해야 한다. (상하좌우 한칸씩 이동 가능하다.)

입력 값
테스트 케이스 여러개
동굴의 크기 N


풀이
가중친 있는 최단 거리 -> 다익스트라


 */

import java.io.*;
import java.util.*;

public class Main {
    static int[][] cave; // 동굴의 도둑루피 배열
    static int[] moveX = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x 좌표
    static int[] moveY = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y 좌표
    static int size; // 동굴의 크기

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int testCase = 0;

        while (true) {
            testCase++;
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            size = Integer.parseInt(tokenizer.nextToken());

            if (size == 0) break; // 종료 조건

            cave = new int[size][size]; // 동굴 초기화
            for (int i = 0; i < size; i++) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                for (int j = 0; j < size; j++) {
                    cave[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            // 출력: 문제 번호와 최소 비용
            System.out.println("Problem " + testCase + ": " + findMinLoss());
        }
        reader.close();
    }

    // 다익스트라 알고리즘을 사용한 최소 비용 탐색 함수
    static int findMinLoss() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 가중치 기준 최소 우선순위 큐
        int[][] minCost = new int[size][size]; // 각 위치까지의 최소 비용 배열
        for (int i = 0; i < size; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE); // 초기화: 모든 값을 INF로 설정
        }

        // 시작점 (0, 0)부터 시작, 초기 비용은 cave[0][0]
        pq.offer(new int[]{0, 0, cave[0][0]});
        minCost[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                // 범위 내에서만 이동
                if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                    int newCost = minCost[x][y] + cave[nextX][nextY]; // 현재 위치에서 다음 위치로 가는 비용 계산

                    // 더 작은 비용이 있으면 갱신
                    if (minCost[nextX][nextY] > newCost) {
                        minCost[nextX][nextY] = newCost;
                        pq.offer(new int[]{nextX, nextY, newCost}); // 갱신된 위치와 비용을 큐에 추가
                    }
                }
            }
        }

        // 도착지점 (size-1, size-1)의 최소 비용 반환
        return minCost[size - 1][size - 1];
    }
}



