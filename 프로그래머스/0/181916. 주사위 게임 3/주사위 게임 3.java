import java.util.Arrays;

class Solution {
   
    public int solution(int a, int b, int c, int d) {
        int answer = 0;  
        int list[] = {a,b,c,d};
        
        Arrays.sort(list); //오름차순 정렬
        
        //모두 같은 경우
        if(list[0] == list[3])
        {
            return 1111*list[0];
        }      
        //세 주사위가 같은 경우
        else if(list[0] == list[2])
        {
            return (int)Math.pow((10*list[0]+list[3]),2);
        }        
        else if(list[1]== list[3])
        {
            return (int)Math.pow((10*list[1]+list[0]),2);
        }       
        //두 개씩 같을 경우 
        else if(list[0] == list[1] && list[2]==list[3])
        {
            return (list[0] + list[2])*Math.abs(list[0] - list[2]);
        }
        //두 개만 같고, 나머지는 각각 다를 경우 
        else if(list[0] == list[1] || list[1] == list[2] || list[2] == list[3])
        {
            if(list[0] == list[1])
            {
                return list[2]*list[3];
            }
            else if(list[1] == list[2])
            {
                return list[0]*list[3];
            }
            else
            {
                return list[0]*list[1];
            }
        }
        //모두 다른 경우 
        else
        {
            return list[0];
        }
        
    }
}