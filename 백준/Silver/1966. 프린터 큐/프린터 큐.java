import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 횟수 받아줌
        int count = Integer.parseInt(br.readLine());

        while (count > 0) {
            // 첫 번째 줄: 문서의 개수 n, 궁금한 문서 index m
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]); // 문서의 개수
            int m = Integer.parseInt(firstLine[1]); // 궁금한 문서의 인덱스

            // 두 번째 줄: 문서들의 중요도
            String[] priorityStrings = br.readLine().split(" ");

            // 큐 선언 -> (문서순서(index) , 중요도)를 배열로 묶음
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(priorityStrings[i]);
                queue.offer(new int[]{i, priority});  // int[] 배열로 인덱스와 중요도를 큐에 추가
            }

            //출력 순서
            int printOrder = 0;

            // 중요도에 따라 인쇄 순서를 결정
            
            // 모든 queue 출력하면 while문 탈출
            while (!queue.isEmpty()) {
                // 현재 문서를 큐에서 꺼냄
                int[] current = queue.poll();
                boolean isMax = true;

                // 큐에 남아있는 문서 중 중요도가 더 높은 문서가 있는지 확인
                for (int[] temp : queue) {
                    if (temp[1] > current[1]) {
                        isMax = false; // 더 중요한 문서가 있으면 false로 변경
                        break;
                    }
                }

                if (isMax) {
                    // 현재 문서가 가장 높은 중요도일 경우, 인쇄
                    printOrder++;
                    if (current[0] == m) {
                        // 궁금한 문서가 인쇄되는 순서 출력
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    // 중요도가 더 높은 문서가 있다면 다시 큐의 맨 뒤로 넣음
                    queue.add(current);
                }
            }
            count--;
        }
    }
}
