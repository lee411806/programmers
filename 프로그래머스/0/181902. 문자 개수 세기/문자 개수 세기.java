class Solution {
    public int[] solution(String my_string) {
        //2024 07 17 2차수정 완
        int[] count = new int[52];
        
        for(int i=0 ; i<my_string.length() ; i++){
            
            if(my_string.charAt(i) >= 'A' && my_string.charAt(i) <= 'Z'){
                
               count[my_string.charAt(i) - 'A']++;
                
            }else if(my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z'){
                
                count[my_string.charAt(i) - 'a'+26]++;
                
            }
            
        }
        
        
        return count;
    }
}