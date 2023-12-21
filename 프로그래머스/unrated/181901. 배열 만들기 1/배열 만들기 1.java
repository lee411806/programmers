import java.util.Arrays;
class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int j=k;
        
        for(int i=0 ; i<answer.length ; i++){
            
           
                answer[i] = j;
                j+=k;
            
        }
 
        
        
        return answer;
    }
}