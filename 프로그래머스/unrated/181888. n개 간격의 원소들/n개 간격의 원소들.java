import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i < num_list.length ; i +=n){
            
            list.add(num_list[i]);
            

        }
        
        
          int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}