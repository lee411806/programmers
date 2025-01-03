/*
문제
마라톤에 참여한 사람 중 비 완주자들을 반환
동명이인이 있을 수 있음

풀이
Map을 이용하여 count 차감 방식

*/

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
      HashMap<String,Integer> map = new HashMap<>();
        
      //참가자 빈도수 추가
      for(String name:participant){
          map.put(name,map.getOrDefault(name, 0) + 1);
      }
        
      //완주자 빈도수 제거
      for (String name : completion) {
          map.put(name, map.get(name) - 1);
      }
        
        
      for (String name : map.keySet()) {
        if (map.get(name) >= 1) {
            return name; // 완주하지 못한 사람 반환
        }
      }
        
        return "에러";
    
    }
}