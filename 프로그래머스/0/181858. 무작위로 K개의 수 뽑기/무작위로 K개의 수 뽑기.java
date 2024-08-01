
import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int k) {
             //20240726 3차 수정
            //2024 08 01 4트 완
            HashSet<Integer> set = new HashSet<>();
            int count=0;
            
            List<Integer> list = new ArrayList<>();    
            
            for(int i=0 ; i<arr.length ; i++){
                if(!set.contains(arr[i])){
                    set.add(arr[i]);
                    list.add(arr[i]);
                     count++;
                }
               
                if(count == k)break;
            }
        
        
            if(list.size() < k){
                while(list.size() <k){
                    list.add(-1);
                }
            }
            
        //한번에 이렇게 하는 경우도 있다.
        /*   for(int i=count; i<k; i++) {
            answer[i]=-1; 
        } */
        
        return list;
     
    }
}

/*
import java.util.*;
class Solution {
    public  List<Integer>  solution(int[] arr, int k) {
            
        // 이 코드는 hashset이 순서를 보장하지 않아서 실행에서 에러가 뜨는 것 같다. -> 순서 보장되는 곳에서 넣어야함   
        HashSet<Integer> set = new HashSet<>();
        
            for(int i=0 ; i<arr.length ; i++){
                 set.add(arr[i]);
                if(set.size() == k)break;
                
            }
            
            List<Integer> list = new ArrayList<>(set);
            
            if(list.size() < k){
                while(list.size() < k){
                    list.add(-1);   
                }
            }
                
            return list;
     
    }
}
*/