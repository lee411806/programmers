import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();
        
            for(int i=0 ; i < flag.length ; i++){
                if(flag[i] == true){
                    for(int j=0 ; j < arr[i] * 2; j++){
                     list.add(arr[i]);    
                    }

                }else{
                    for(int j=0 ; j < arr[i] ; j++){
                    list.remove(list.size() - 1);    
                    }

                }
            }

        return list;
    }
}