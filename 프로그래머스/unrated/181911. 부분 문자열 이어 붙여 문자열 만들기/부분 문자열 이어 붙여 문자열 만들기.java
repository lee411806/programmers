class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
                for(int i=0 ; i<my_strings.length ; i++){
                    
                   sb.append(my_strings[i].substring(parts[i][0], parts[i][1]+1));
                
                }
                    
                   answer = sb.toString();
        
        return answer;
    }
}