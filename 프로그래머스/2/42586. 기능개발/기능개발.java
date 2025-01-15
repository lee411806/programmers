/*
문제
작업진척도, 작업속도를 활용하여 작업일 수를 구하고 각 배포때 몇개의 작업이 완료되었는지 반환
단 작업진척도 배열에서 앞의 작업일 수보다 뒤에 작업일 수가 작으면 배포못함, 배포하면 다시 초기화

문제풀이
1. 작업일 수를 queue로 나타낸다.
2. queue에서 앞과 뒤를 비교하여 각 배포때 몇개의 작업이 완료되었는지 판단 후 배열에 넣기
*/
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int x = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            if (x >= q.peek()) {
                count++;
                q.poll();
            } else {
                list.add(count);
                count = 1;
                x = q.poll();
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}