import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
            boolean firstTwo = false;
            boolean secondTwo = false;
            int firstIndex = -1;
            int lastIndex = -1;
        
        
            for(int i=0 ; i<arr.length ; i++){
                
                if(arr[i] == 2){
                    firstTwo = true;
                    firstIndex = i;
                    break;
                }
                
            }
        
        
            for(int i=arr.length -1 ; i>= 0 ; i--){
                
                if(arr[i] == 2){
                    secondTwo = true;
                    lastIndex = i;
                    break;
                }
                
            }
            
            int[] result;
                
            if(firstTwo && secondTwo){
                return result = Arrays.copyOfRange(arr, firstIndex, lastIndex+1);
            }else{
                return result = new int[]{-1};
            }
        
        
        
        
    }
}