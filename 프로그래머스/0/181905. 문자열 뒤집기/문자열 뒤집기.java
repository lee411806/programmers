
class Solution {
    public String solution(String my_string, int s, int e) {
      
        //2024 07 26 3차 수정
        //2024 08 02 4차 수정
          String answer = my_string.substring(0, s);
        for(int i = e; i >= s; i--){
            answer += my_string.charAt(i);
        }
        answer += my_string.substring(e + 1);
        return answer;
        
        
    }
}