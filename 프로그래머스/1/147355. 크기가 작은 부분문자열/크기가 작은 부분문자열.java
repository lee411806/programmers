class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String temp="";    
            for(int i=0 ; i < t.length(); i++){
                
                
                temp = t.substring(i,i+p.length());
               
                if(Long.parseLong(temp)<= Long.parseLong(p)){
                    answer++;
                }
                System.out.println(temp);
                
                
                if(i+p.length() == t.length()){
                    break;
                }
            
            }        
        
        
        return answer;
    }
}