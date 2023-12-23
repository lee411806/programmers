import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] arr, int k) {
        
        List<Integer> list = new ArrayList<>();
        
                for(int i=0; i< arr.length ; i++){
                    if(k % 2 ==1){
                        arr[i] *= k;
                        list.add(arr[i]);
                    }
                    
                    if(k%2 ==0){
                           arr[i] += k;
                        list.add(arr[i]);
                    }

                }
        
           
        
        
        return  list.stream().mapToInt(Integer::intValue).toArray();
    }
}