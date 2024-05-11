class Solution {
    public int[] solution(String myString) {
        // 문자열을 "x" 기준으로 분할, 빈문자열까지 배열로 반환
        String[] s = myString.split("x",-1);
        
        // 결과 배열 생성 (분할된 요소 수만큼)
        int[] answer = new int[s.length];
        
        // 각 분할된 문자열의 길이를 결과 배열에 저장
        for (int i = 0; i < s.length; i++) {
            answer[i] = s[i].length();
        }
        
        return answer;
    }
}