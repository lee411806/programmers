class Solution {
    public String solution(String s) {
        String answer = "";
        int len= s.length();
        
        // if(len%2==1){
        //         answer = s.substring((len-1) / 2, (len-1) / 2+1);
        //     }else if(len%2==0){
        //         answer = s.substring(len - (len/2) -1, len - (len/2)+1);
        // }
        
        answer = (len%2==1)? s.substring((len-1) / 2, (len-1) / 2+1):s.substring(len - (len/2) -1, len - (len/2)+1);
        
        
        return answer;
    }
}