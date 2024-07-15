import java.util.*; 
class Solution {
    public int solution(String[] strArr) {
        
        // 2024 07 15 2차 복습 졸업
        
        int[] intArr = new int[30];
        
        for(int i=0 ; i < strArr.length ; i++){
            
            //인덱스는 0부터 시작임으로 개수 -1 해서 인데스 증가 시키고, 나중에 글자길이 물어볼때 +1 하면 됨
            intArr[strArr[i].length()-1]++;
            
        }
        
        Arrays.sort(intArr);
        
        
        return intArr[intArr.length-1];
            
    }
}