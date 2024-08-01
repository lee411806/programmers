import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
          // 20240725 -> 3차복습 사소한 실수 또함!
        //2024 08 01 3트 
            
      //     boolean firstTwo = false;
        //    boolean secondTwo = false;   첫번째, 두번째 2의 유무를 boolean으로 나타낼 수 있다.  
        int startIndex = -1;
        int endIndex = -1;
        
        for(int i=0 ; i< arr.length ; i++){
            if(arr[i] == 2){
                startIndex = i;
                break;
            }
        }
        
        
        for(int i=arr.length-1 ; i>=0 ; i--){
            if(arr[i] ==2){
                endIndex=i;
                break;
            }
        }
        
        int[] result;
        
        if(startIndex != -1 && endIndex != -1){
            result = Arrays.copyOfRange(arr, startIndex, endIndex +1);
        }else {
            result = new int[]{-1};
        }
        
        
            return result; 
        
        
        
    }
}