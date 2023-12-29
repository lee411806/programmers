class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int count =0;
        
             for(String str : seoul){
                 
                 if(str.equals("Kim")){
                     break;
                 }
                 count++;
             }   
        
       
                answer ="김서방은 " +count+"에 있다";
        
        
        return answer;
    }
}