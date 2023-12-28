import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int[] arr, int n) {
       
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i< arr.length ;i++){
            if(arr.length % 2 == 1){
                if(i % 2 == 0){
                    list.add(arr[i]+n);
                }else{
                    list.add(arr[i]);
                }
            }
            
              if(arr.length % 2 == 0){
                if(i % 2 == 1){
                     list.add(arr[i]+n);
                }else{
                       list.add(arr[i]);
                }
            }
            
        
        }
        
        
        return list;
    }
}