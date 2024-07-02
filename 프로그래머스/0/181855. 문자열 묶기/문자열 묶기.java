import java.util.*; 
class Solution {
    public int solution(String[] strArr) {
        
        int[] iArray = new int[30];
        
        for(int i =0 ; i < strArr.length ; i++){
            iArray[strArr[i].length()-1]++;
        }
        
        Arrays.sort(iArray);
        
        return iArray[29];
     
    }
}