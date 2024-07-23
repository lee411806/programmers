import java.util.*;
class Solution {
    public List<String> solution(String[] picture, int k) {
            
        // 20240723 2차 복습 완
        
        List<String> list = new ArrayList<>();
         
        
        for(int i=0 ; i < picture.length ;i++){
          String temp = "";  
          char[] c = picture[i].toCharArray();
            
            for(int j=0 ; j < c.length ; j++){
               for(int l = 0 ; l< k ; l++){
                 temp += c[j];    
               }
               
            }
        
             for(int m = 0; m < k; m++){
                 list.add(temp);
            
            }
        
        
        
        }
        
        return list; 
        
     
    }
}