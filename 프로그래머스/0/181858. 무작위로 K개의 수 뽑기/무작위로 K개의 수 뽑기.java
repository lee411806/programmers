class Solution {
    public int[] solution(int[] arr, int k) {
          int[] answer = new int[k];
        int count = 1;
        
        if (arr.length > 0) {
            answer[0] = arr[0];
        }
        
        for (int i = 1; i < arr.length && count < k; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (answer[j] == arr[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                answer[count] = arr[i];
                count++;
            }
        }
        
        for (int i = count; i < k; i++) {
            answer[i] = -1;
        }
        
        return answer;
    }
}