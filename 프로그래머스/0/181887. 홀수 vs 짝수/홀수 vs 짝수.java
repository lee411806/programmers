class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum_odd=0;
        int sum_even=0;
        
        for(int i=1 ; i <= num_list.length ; i++){
            if(i % 2 == 1){
                sum_odd += num_list[i-1];
            }else if(i % 2 == 0){
                 sum_even += num_list[i-1];
            }
        }
        
        answer = sum_odd >= sum_even ? sum_odd : sum_even; 
        
        return answer;
    }
}