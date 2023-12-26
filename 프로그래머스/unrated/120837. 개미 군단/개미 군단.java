class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int num = 0; 
        int rest=0;
        num = hp / 5;
        rest = hp % 5;
        
        num += rest / 3;
        rest = rest % 3;
        
        num += rest / 1;
        
        answer =num;
        
        return answer;
    }
}