import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] c = new char[s.length()];
        
        for(int i=0 ; i<s.length() ;i++){
            c[i] = s.charAt(i);
        }
                
            Arrays.sort(c);
        
                    
                    for(int i=0 ; i<s.length() ; i++){
                        answer += c[s.length() - (i+1)];
                    }
            
        
        return answer;
    }
}