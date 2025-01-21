/*
문제
1.대기 큐에서 하나 꺼내는데 더 높은 우선순위가 있다면 다시 넣기
2.우선순위가 가장 높다면 꺼내기

풀이
location위치에 있는 값이 최대 우선순위가 될때 까지 queue를 돌리면서 중요도가 높은 값 꺼내기
꺼낼 때마다 +1

*/

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
          int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int num : priorities) {
			pq.add(num);
		}
		while(!pq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					pq.poll();
					answer++;
					if(i == location)
						return answer;
				}
			}
		}  
        return answer;
    }
}