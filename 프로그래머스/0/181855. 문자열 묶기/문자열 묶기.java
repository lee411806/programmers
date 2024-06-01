class Solution {
    public int solution(String[] strArr) {
        
        int[] count = new int[30]; 
        
        for(int i=0; i < strArr.length  ;i++){
            count[strArr[i].length()-1]++; 
        }
        
        int max =0;
        for(int i=0 ; i<count.length ; i++){
            if(max < count[i]){
                max = count[i];
            }
        }
        
        
        return max;
    }
}