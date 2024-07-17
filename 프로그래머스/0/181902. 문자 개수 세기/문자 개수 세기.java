class Solution {
    public int[] solution(String my_string) {
        
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