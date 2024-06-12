import java.util.*;
class Solution {
    public List<String> solution(String[] str_list) {
       
        int left =-1;
        int right =-1;
        
        for(int i=0 ; i < str_list.length ; i++){
            if(str_list[i].equals("l")){
                left = i;
                break;
            }else if(str_list[i].equals("r")){
                right = i;
                break;
            }
        }
        
        
        List<String> list = new ArrayList<>();
        if(left != -1){
            for(int i=0 ; i< left ; i++){
                list.add(str_list[i]);
            }
        }else if(right != -1){ 
            for(int i=right+1 ; i<str_list.length ; i++){
                list.add(str_list[i]);
            }
        }
        
        
        
        return list;
    }
}