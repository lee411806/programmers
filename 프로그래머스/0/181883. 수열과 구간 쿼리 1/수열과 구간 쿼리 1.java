class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for(int i=0 ; i < queries.length ; i++){
            for(int j = queries[i][0] ; j <=  queries[i][1] ; j++){
                arr[j] = arr[j] + 1;
            }        
        }
        
        
        
        return arr;
    }
}