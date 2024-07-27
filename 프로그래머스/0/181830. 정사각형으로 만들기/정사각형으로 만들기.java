class Solution {
    public int[][] solution(int[][] arr) {
        
        //2024 07 27 3차 수정
        int row = arr.length;
        int col = arr[0].length;
        
        if(row > col){
            int[][] rectangle = new int[row][row];
                
                for(int i=0 ; i < row ; i++){
                    for(int j=0 ; j < col ; j++){
                        rectangle[i][j] = arr[i][j];
                    }
                }
            
            return rectangle;
        }else if(col > row){
             int[][] rectangle = new int[col][col];
            
            for(int i=0 ; i < row ; i++){
                for(int j=0 ; j <col ; j++){
                    rectangle[i][j] = arr[i][j];
                }
            }
            return rectangle;
            
        }else {
            return arr;
        }
        
        
        
    }
}