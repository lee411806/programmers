class Solution {
    public long solution(long n) {
        long answer = 0;
        double x = Math.sqrt(n);
        
        if(x == Math.floor(x)){
            answer = (long) ( (x+1) * (x+1) );
        }else{
            answer=-1;
        }
        
        return answer;
    }
}