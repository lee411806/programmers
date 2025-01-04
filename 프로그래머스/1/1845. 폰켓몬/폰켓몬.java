/*
문제
폰켓몬의 수 , 가져갈 마리수 주어짐
중복되는 폰켓몬 있음
가장 많은 폰켓몬의 수를 가져가는 방법

풀이
set으로 중복 제거 후 n/2 와 set의 크기와 비교
1. set 크기가 n/2보다 크거나 같다면 n/2가 최대 종류의 수가 될 것이고
2. set 크기가 n/2보다 작다면 set크기가 최대 종류의 수가 될것이다.

*/

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int temp : nums){
            set.add(temp);
        }
        
        
        if(set.size() >= nums.length/2){
            return nums.length / 2;
        }else{
            return set.size();
        }
    }
}