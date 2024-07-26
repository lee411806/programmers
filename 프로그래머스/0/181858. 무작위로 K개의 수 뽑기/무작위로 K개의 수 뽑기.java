
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
            //20240726 3차 수정
               HashSet<Integer> set = new HashSet<>();
        int[] answer=new int[k];
        
        int count=0;
        for(int i=0; i<arr.length; i++) {
            if(!set.contains(arr[i])) {
                set.add(arr[i]);
                answer[count]=arr[i];
                count++;
            }
            if(count==k) {
                break;
            }
        }
        for(int i=count; i<k; i++) {
            answer[i]=-1; 
        }
        
        
        return answer;
     
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