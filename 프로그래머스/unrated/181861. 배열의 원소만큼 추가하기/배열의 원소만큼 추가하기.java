import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] arr) {
     
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i< arr.length; i++){
            
            for(int j=0 ; j< arr[i];j++){
                list.add(arr[i]);
            }
            
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}