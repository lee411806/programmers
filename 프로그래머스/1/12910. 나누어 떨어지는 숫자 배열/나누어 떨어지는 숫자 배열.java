import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        int[] answer = {};
        int count =0;
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(arr);
        
            for(int i=0 ; i<arr.length ;i++){
                if(arr[i] % divisor ==0){
                    list.add(arr[i]);
                    count++;
                }
            }
            
                if(count==0){
                    list.add(-1);
                }
        
        
        
        
        return list;
    }
}