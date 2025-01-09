/*
문제)
매일 입는 옷 조합 
1. 종류 별 최대 1가지
2. 의상이 겹치더라도 다른 종류를 추가하면 착용한걸로 계산
3. 하루에 최소 한 개의 의상

풀이)
1.경우의 수를 매일로 잡는다면 모든 경우의 수를 더해야, 서로 다른 옷의 조합이 나옴
2.그렇다면 종류별 개수를 곱해주면 모든 종류의 수가 나옴
3.주의할 점은 그 종류의 의상을 포함안할 수 있음으로 종류별 의상 없음 을 추가해준다. (ex. 안경하나만 착용하면 나머지 의상 종류는 의상없음 이다.)
4.계산 이후 모든 종류의 의상 입지않음의 경우의수를 빼준다.

5. map에 종류 종류의수를 넣고 map의 모든 value+1 후 모두 곱한후 -1
점화식 : key1.value+1 * key2.value + 1 .... - 1
*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {   

       Map<String,Integer> map = new HashMap<>();

       for (int i = 0; i < clothes.length; i++) { 
       String key = clothes[i][1]; 

       map.put(key, map.getOrDefault(key, 1) + 1);
       }        
        
        int result = 1;
        
        for(int value : map.values()){
            result *= value;
        }
        
        return result - 1;
        
    }
}