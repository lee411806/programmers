class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        
        for(int i=0 ; i<cipher.length()+1 ; i++){
               
            if(i % code == 0 && i != 0) {  
            answer += String.valueOf(cipher.charAt(i-1));
                
            }
        }
        
        
        return answer;
    }
}