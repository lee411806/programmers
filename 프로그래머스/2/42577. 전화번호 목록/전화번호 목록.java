/*
문제
접두사 유무에따른 bool반환

문제 풀이
1.String startsWith를 활용하여 접두사 유무 확인 --> 테스트 케이스 통과 안됨

1번 안되었던 이유 -> 맨처음 접두사가 다른번호의 접두어가 아니라 "한 번호가 다른 번호의 접두어인 경우"이다. 

2. sort로 배열 정렬을 먼저 해준 다음에 접두사 뒤에 문자열만 확인


*/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for(int i=0 ; i < phone_book.length-1 ; i++){
            
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
            
        }
        
        return true;   
    }
}


/* 1번 풀이
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = false;
        
        for(int i=1; i<phone_book.length ; i++){
            
            if(phone_book[i].startsWith(phone_book[0])){
                answer = false;
                break;
            }else{
                answer = true;
            }
            
        }
        
         
        return answer;
    }
}
*/