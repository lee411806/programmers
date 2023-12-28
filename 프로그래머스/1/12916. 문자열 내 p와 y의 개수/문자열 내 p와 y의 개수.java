class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String s1="";
        int pCount=0;
        int yCount=0;
        
        s1 = s.toLowerCase();
        
            for(int i=0 ; i< s.length() ; i++){
                    if( 'p' == s1.charAt(i)){
                        pCount++;
                    }
                     if( 'y' == s1.charAt(i)){
                        yCount++;
                    }
            }
            
            answer = (pCount == yCount)? true : false;
                        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}