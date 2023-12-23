import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
         if (n <= 0 || n > num_list.length) {
            // 유효하지 않은 n이 주어진 경우 빈 배열 반환
            return new int[0];
        }

        // num_list 배열에서 첫 번째 원소부터 n 번째 원소까지 추출
        return Arrays.copyOfRange(num_list, 0, n);
    }
}