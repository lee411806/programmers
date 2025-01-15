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
    
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0 ; i<progresses.length ; i++){
            
            if((100 - progresses[i]) % speeds[i] == 0){
                queue.add((100 - progresses[i]) / speeds[i]);
            }else{
                 queue.add((100 - progresses[i]) / speeds[i] + 1);
            }
            
        }
        
        int first = queue.poll();
        int count = 1;
        
        while(!queue.isEmpty()){
            if(first >= queue.peek()){
                count++;
                queue.poll();
            }else{
                list.add(count);
                count = 1;
                //first 초기화
               first = queue.poll();
            }
        }
        //마지막 요소 더해줌
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
        
    }
}