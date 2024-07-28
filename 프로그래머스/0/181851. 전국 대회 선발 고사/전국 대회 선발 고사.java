import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
                    
        //2024 07 28 3차 수정
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i < attendance.length ; i++){
            
             if(attendance[i] == true){
                 
                    map.put(rank[i], i);
                 
             }
        
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list);
        
          int a = map.get(list.get(0));    
          int b = map.get(list.get(1));
          int c = map.get(list.get(2));
        
        return 10000 * a + 100 * b + c;
        
     
    }
}