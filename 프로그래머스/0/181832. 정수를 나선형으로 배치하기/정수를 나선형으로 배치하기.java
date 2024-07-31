class Solution {
    public int[][] solution(int n) {
        
        int count = 1;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart =0;
        int colEnd = n-1;
        
        int[][] array = new int[n][n];
        
        while(count <= n*n){
            
            for(int i= colStart ; i <= colEnd ; i++){
                array[rowStart][i] = count++;
                
            }
                rowStart ++;
            
            for(int i= rowStart; i <= rowEnd  ; i++){
                array[i][colEnd] = count++;
            }
                colEnd --;
            
            for(int i= colEnd ; i>= colStart ; i--){
                array[rowEnd][i] = count++;
                
            }
                rowEnd --;
            
            for(int i=rowEnd ; i>=rowStart ; i--){
                array[i][colStart] = count++;
                
            }
                colStart++;
            
            
        }
            
        return array;
        
    }
}