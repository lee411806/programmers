
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int numbers_len = numbers.length; // 변수 선언 및 초기화
        
        int[] answer = new int[numbers_len];
            
        for (int i = 0; i < numbers_len; i++) {
            if (direction.equals("right")) { // 문자열 비교 수정
                if (i == numbers_len - 1) {
                    answer[0] = numbers[i];
                } else {
                    answer[i + 1] = numbers[i]; // 배열 설정 수정
                }
            } else {
                if (i == 0) {
                    answer[numbers_len - 1] = numbers[i];
                } else {
                    answer[i - 1] = numbers[i]; // 배열 설정 수정
                }
            }
        }
        
        return answer; // 반환 문 추가
    }
}