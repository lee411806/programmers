import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
          String answer = "";
          BigInteger bigIntA = new BigInteger(a);
           BigInteger bigIntB = new BigInteger(b);
            
        
           BigInteger sum = bigIntA.add(bigIntB);
        
        return answer + sum;
    }
}