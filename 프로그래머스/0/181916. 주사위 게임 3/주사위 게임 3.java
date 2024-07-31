import java.util.Arrays;

class Solution {
   
    public int solution(int a, int b, int c, int d) {
                
          //20240724 2차복습
          //20240731 3차 복습
        
            int[] li = {a,b,c,d};
        
            Arrays.sort(li);
        
            //네 숫자가 모두 같음
            if(li[0] == li[3]){
                return 1111 * li[0];
            }
                // 세 주사위가 같음 case1
            else if(li[0] == li[2]){
                return  (int) Math.pow(10 * li[0] + li[3], 2);
            }
                // 세 주사위가 같음 case2
            else if(li[1] == li[3]){
                return  (int) Math.pow(10 * li[1] + li[0], 2);
            }
                //두 개씩 같은 값이 나올 때
            else if(li[0] == li[1] && li[2] == li[3]){
                return (li[0] + li[2]) * Math.abs(li[0] - li[2]);
            }
                // 두 주사위에서 나온 숫자가 p로 같고 나머지 숫자가 각각 다름
            else if(li[0] == li[1] || li[1] == li[2] || li[2] == li[3]){
                if(li[0] == li[1]){
                    return li[2] * li[3];
                }else if(li[1] == li[2]){
                       return li[0] * li[3];
                }else if( li[2] == li[3]){
                     return li[0] * li[1];
                }else {
                    return 1;
                }
                
            }
                // 네 수자위에 숫자가 모두 다르다면
            else {
                return li[0];
            }
        
    }
}