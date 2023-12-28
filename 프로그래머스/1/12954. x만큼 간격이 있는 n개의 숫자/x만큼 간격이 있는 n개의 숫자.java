class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        int index=0;
        
        if(x>0){
            for(long i=x; i<= x*n ; i+=x){
                answer[index] = i;
                    index++;
            }    
         }
          else if(x<0){
             for(long i=x; i>= x*n ; i+=x){
                 answer[index] = i;
                   index++;
                }    
            }else if(x==0){
                answer[0] = 0;
          }
        
        return answer;
    }
}