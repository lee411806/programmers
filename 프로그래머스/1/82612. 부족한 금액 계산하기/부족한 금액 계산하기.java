class Solution {
    public long solution(int price, long money, int count) {
        long answer = -1;
        long sum =0;         
                for(int i=1; i<=count ; i++){
                    sum += price * i;
                }
        
                answer = (sum >money)? sum-money: 0;     
        return answer;
    }
}