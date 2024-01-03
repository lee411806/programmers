class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len = arr1.length;
        int[][] answer = new int[len][arr1[0].length];   
        
        
        for(int i=0 ; i< len ; i++){
            for(int j=0; j< arr1[0].length;j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        
        return answer;
    }
}