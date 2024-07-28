import java.util.*;
class Solution {
    public List<String> solution(String[] picture, int k) {
            
        //2024 07 28 3차 복습
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
            
            
        for(int i=0 ; i < picture.length ; i++){
            
            char[] c = picture[i].toCharArray();
            
            for(int j=0 ; j < c.length ; j++){
            
                for(int l=0 ; l < k ; l++){
                    sb.append(c[j]);
                }  
                
               
             
            }
            
            
            
            
         
                    for(int m=0 ; m<k ; m++){
                         list.add(sb.toString());
                    }
             
            
               sb.setLength(0);
            
        }
        
        
        return list;
            
     
    }
}