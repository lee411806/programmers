import java.util.*;
class Solution {
    public List<String> solution(String myStr) {
        List<String> list = new ArrayList<>();
        String temp="";    
        for(int i=0 ; i < myStr.length() ; i++){
           char c = myStr.charAt(i);
           if(c == 'a' || c == 'b' || c == 'c'){
               if(temp != ""){
                   list.add(temp);
                   temp="";
               }
           }else{
               temp += c;
           }
            
        }
               if(temp != ""){
                   list.add(temp);
                   temp="";
               }
        
               if(list.size() == 0){
                   list.add("EMPTY");
               } 
                
        
        return list;
    }
}