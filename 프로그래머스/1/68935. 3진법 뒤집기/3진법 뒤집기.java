import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
            
            List<Integer> list = new ArrayList<>();
        
            
            int b = 1;
        
                while(n>0){
                    int remainder = n % 3;
                     list.add(remainder);
                       n /= 3;
                }
                        System.out.println(list);
                        
                        for(int i=0 ; i<list.size() ;i++){
                                
                            
                               answer+= list.get(list.size() - (i+1)) * (int)Math.pow(3,i); 
                            System.out.println(list.get(i));
                            System.out.println(answer);
                                
                        }
            
        
        
        return answer;
    }
    
    

}


