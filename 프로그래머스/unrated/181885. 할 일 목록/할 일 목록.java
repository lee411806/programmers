import java.util.*;
class Solution {
    public List<String> solution(String[] todo_list, boolean[] finished) {
        
        List<String> list = new ArrayList<>();
        Map<String, Boolean> m = new HashMap<>();
        Set<String> keySet = m.keySet();
                                     
                for(int i=0 ; i<todo_list.length ; i++){
                    m.put(todo_list[i], finished[i]);
                    if(m.get(todo_list[i])==false){
                        list.add(todo_list[i]);
                    }
                }
        
        
        
        
        
        return list;
    }
}