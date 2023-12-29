import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        List<Integer> list = new ArrayList<>();
        int y = x;
            while(x>0){
                list.add(x%10);
                x/=10;
            }

              int sum=0;

                for(int i=0 ; i< list.size(); i++){
                    sum+= list.get(i);
                }

                        answer = (y%sum == 0)? true: false;
        return answer;
    }
}