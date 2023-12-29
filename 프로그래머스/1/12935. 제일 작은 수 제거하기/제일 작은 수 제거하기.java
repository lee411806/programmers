import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int min = arr[0];
        
        List<Integer> list = new ArrayList<>();
        
                for(int i=0 ; i<arr.length ;i++){
                       if(arr[i]<min){
                           min = arr[i];
                       }
                    
                        
                    
                }
                    
                        for(int i=0 ; i<arr.length ;i++){
                           
                            if(arr[i]!= min){
                                    list.add(arr[i]);    
                            }    
                             
                        }
        
                            
                               
                         if (list.isEmpty()) {
                                list.add(-1);
                          }
        
        return list;
    }
}