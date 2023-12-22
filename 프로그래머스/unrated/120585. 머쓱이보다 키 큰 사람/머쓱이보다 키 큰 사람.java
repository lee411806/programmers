class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for(int classHeight : array){
            if(classHeight >height){
                answer++;
            }
        }
        
        return answer;
    }
}