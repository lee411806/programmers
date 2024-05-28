import java.util.*;
class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        int temp =0;
        for(int i=0 ; i < intStrs.length ; i++){
             temp = Integer.parseInt(intStrs[i].substring(s, s + l));
            if(temp > k){
            
            list.add(temp);
                
            }
        }
        
        
        return list;
    }
}