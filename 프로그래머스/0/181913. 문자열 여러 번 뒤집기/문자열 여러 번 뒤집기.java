class Solution {
    public String solution(String my_string, int[][] queries) {
        //2024 0727 3차수정 완
        char[] c = my_string.toCharArray();
        String result ="";
        for(int i=0 ; i < queries.length ; i++){
            int start = queries[i][0];
            int end = queries[i][1]; 
            
            while(start < end){
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                
                start++;
                end--;
            }
        
        }
        
        result = String.valueOf(c);
        return result;
    }
}