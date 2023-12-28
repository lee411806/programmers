class Solution {
    public long[] solution(long n) {
        long temp = n;
        int answerLen=0;
         while(temp>0){
              answerLen++;
            temp/=10;
            
        }      
    
             
                 long[] answer = new long[answerLen];
        
                                for(int i=0 ; i<answerLen ;i++){
                                  
                                answer[i] = (n%10);
                                    n/=10;
                                    
                                }
                                
                            
        
        return answer;
    }
}