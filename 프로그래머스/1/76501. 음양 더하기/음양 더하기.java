
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        int[] multipleArr = new int[len];
        int[] a = new int[len];
        
        
            
        
        
                    for(int i=0 ; i< len; i++){
                        a[i] = signs[i]? 1:-1;
                        multipleArr[i] = absolutes[i] * a[i];
                        answer += multipleArr[i];
                    }

        
        return answer;
    }
}