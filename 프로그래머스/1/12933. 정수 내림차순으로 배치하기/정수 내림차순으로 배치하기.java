import java.util.*;

class Solution {
    public long solution(long n) {
        String str = ""+n;
        int[] arr = new int[str.length()];
        for(int i=0; i< str.length(); i++) {
            arr[i] = (int)(n%10);
            n/=10;
        }

        Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());

        long answer = 0;
        int num = tmp.length;

        for(int i=0; i< tmp.length; i++) {
            answer += tmp[i] * (long) Math.pow(10, num-1);
            num-=1;

        }
        return answer;
    }
}