import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
            
            // 20240725 -> 3차복습 사소한 실수 또함!
            int firstIndex = -1;
            int endIndex = -1;
            boolean firstTwo = false;
            boolean secondTwo = false;    
        
        for(int i=0 ; i < arr.length ; i++){
            if(arr[i] == 2){
                firstIndex = i;
                firstTwo = true;
                break;
            }
        }
        
        for(int i= arr.length-1 ;  i>=0 ; i--){
            if(arr[i] == 2){
                endIndex = i;
                secondTwo = true;
                break;
            }
        }
        
        int[] result; 
        if(firstTwo && secondTwo){
        result = Arrays.copyOfRange(arr, firstIndex, endIndex+1);  
        }else{
            result = new int[]{-1};
        }
        
        return result;
        
    }
}