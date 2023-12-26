import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
            
        List<Integer> list = new ArrayList<>();
        
        for(int i=1 ; i<= n; i++){
            if(n % i ==1){
                list.add(i);
            }
        }
        
           int answer  = Collections.min(list);
        
        
        
        return answer;
    }
}