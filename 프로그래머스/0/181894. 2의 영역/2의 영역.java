import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
       
        int firstIndex =-1; 
        int endIndex = -1;
        boolean twoTrue1 = false;
        boolean twoTrue2 = false;
        for(int i=0 ; i<arr.length ; i++){
           
            if(arr[i] == 2 ){
                firstIndex = i;
                twoTrue1 = true;
                break;
            }
        }
        
        for(int i = arr.length-1 ; i>=0 ; i--){
            if(arr[i] == 2 ){
                endIndex = i;
                twoTrue2 = true;
                break;
            }
        }
        int[] answer;
        if(twoTrue1 && twoTrue1){
            answer = Arrays.copyOfRange(arr, firstIndex, endIndex + 1);
        }else{
              answer = new int[] {-1};
        }
        
        
        
        return answer;
    }
}