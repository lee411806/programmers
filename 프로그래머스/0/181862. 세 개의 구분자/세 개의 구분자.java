import java.util.*;
class Solution {
    public List<String> solution(String myStr) {
                    
        //2024 07 15 2차 복습 -> 문제 졸업
        
        List<String> list = new ArrayList<String>();
        
        String temp = "";
        
        
        for(int i=0 ; i < myStr.length() ; i++){
            char c = myStr.charAt(i);
            if(c == 'a' || c =='b' || c =='c'){
                if(temp.equals("")){
                    
                }else{
                    list.add(temp);
                    temp = "";
                }
            }else{
                 temp += c;
            }
            
        }
        
        if(temp != ""){
        list.add(temp);    
        }
        
        if(list.isEmpty()){
            list.add("EMPTY");
        }
        
        
        return list;
    }
}