class Solution {
    public String solution(int num) {
        String answer = "";
       // answer = (num%2==1 || num%2==-1)?  "Odd" : (num%2==0)? "Even": "Unknown" ;
        answer = (num%2 ==0)? "Even" : "Odd";
        return answer;
    }
}