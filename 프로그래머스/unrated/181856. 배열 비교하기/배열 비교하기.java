import java.util.Arrays;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
       
        
           int arr1Sum = Arrays.stream(arr1).sum();
         int arr2Sum = Arrays.stream(arr2).sum();
        
        if(arr1.length > arr2.length){
            answer=1;
        }else if(arr1.length < arr2.length){
            answer=-1;
        }
        
        if(arr1.length == arr2.length){
            if(arr1Sum>arr2Sum){
            answer = 1;    
            }else if(arr1Sum<arr2Sum){
                answer = -1;
            }else{
                answer=0;
            }
            
        }
        
        return answer;
    }
}