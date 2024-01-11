import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
                
            Map<Character, Integer> m = new HashMap<>();
              Set<Character> keySet = m.keySet();
            
                
            
            
                       for (int i = 0; i < s.length(); i++) {
                    char currentChar = s.charAt(i);

                    
                    if (m.containsKey(currentChar)) {
                        answer[i] = i - m.get(currentChar);
                    } else {
                       
                        answer[i] = -1;
                    }

                    
                    m.put(currentChar, i);
                     }

              
                for (int val : answer) {
                    System.out.print(val + " ");
                }
        
        return answer;
    }
}