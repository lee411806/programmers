class Solution {
    public int[] solution(int[] arr) {
        
        int newLen =1;
        
        while(newLen < arr.length){
            newLen *=2;
        }
        
        int[] answer = new int[newLen];
        
        for(int i=0 ; i<arr.length ; i++){
            answer[i] = arr[i];
        }
        
        
        return answer;
    }
}