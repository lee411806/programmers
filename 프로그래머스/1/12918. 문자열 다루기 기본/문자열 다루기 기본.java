class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        for(int i =0 ;  i<s.length() ; i++){
               if(Character.isDigit(s.charAt(i)) == false){
                   answer = false;
               }
        }
        
            if(!(len == 4 || len == 6)){
                answer =false;
            }
            
      
        return answer;
    }
}