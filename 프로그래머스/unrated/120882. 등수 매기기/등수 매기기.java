class Solution {
    public int[] solution(int[][] score) {
        int[] result = new int[score.length];
        int[] answer = new int[score.length];
        int count = 1;
        
        for(int i =0; i < score.length;i++ ){
          result[i] = score[i][0] + score[i][1];
        }
        
              for(int i =0; i < score.length;i++ ){
                  
            for(int j=0; j<score.length;j++){
                
                if( result[i] <  result[j]){
                   count++; 
                }             
            }       
        answer[i] =   count;
            count =1;
        }
        return answer;
    }
}