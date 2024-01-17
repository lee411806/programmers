import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        
            for(int i=1 ; i<food.length; i++){
                for(int j=0; j<(int)(food[i]/2) ; j++){
                list.add(i);    
                }
                
            }
            list.add(0);
            
            for(int i=list.size()-2; i>=0 ; i--){
                  
                list.add(list.get(i));
            }
        
        
        
        
            for(int i=0 ; i<list.size() ; i++){
             answer += list.get(i);
            }
            
            
        
        
        return answer;
    }
}