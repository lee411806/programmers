class Solution {
    public String[] solution(String[] names) {
        
        int names_len = names.length / 5 + 1;
        
        if(names.length % 5 == 0){
          names_len = names.length / 5;      
        }
        
        
        String[] answer = new String[names_len];
        int count =0;
        for(int i=0 ; i<names.length ; i+= 5){
            
            answer[count] = names[i];
            count++;
        }
        
        
        return answer;
    }
}