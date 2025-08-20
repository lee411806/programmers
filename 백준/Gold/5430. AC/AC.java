

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int N;
   static int r;
   static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

         while(T-- > 0) {
            String p = br.readLine();  // 함수 문자열 (RDD, DD, RRD, D)
            int n = Integer.parseInt(br.readLine());  // 배열 크기
            String arrStr = br.readLine();  // 배열 문자열 "[1,2,3,4]"

            // 배열을 Deque에 저장
            Deque<Integer> deque = new ArrayDeque<>();

             int[] arr = new int[n];

             if(n > 0) {
                 String[] nums = arrStr.substring(1, arrStr.length()-1).split(",");
                 for(int i = 0; i < n; i++) {
                     deque.add(Integer.parseInt(nums[i]));
                 }
             }


             //방향 기억
             boolean isReversed = false;
             boolean isError = false;

             for(int i=0 ; i<p.length() ; i++){
                 if(p.charAt(i) == 'R'){
                     isReversed = !isReversed;
                 }else {
                     if(deque.isEmpty()){
                         isError= true;
                         break;
                     }

                     if (!isReversed) {
                         deque.removeFirst();
                     } else {
                         deque.removeLast();
                     }
                 }
             }

             // 결과 출력
             if(isError) {
                 System.out.println("error");
             } else {
                 StringBuilder sb = new StringBuilder();
                 sb.append("[");

                 if(!deque.isEmpty()) {
                     if(!isReversed) {
                         // 정방향: 앞에서부터 출력
                         while(!deque.isEmpty()) {
                             sb.append(deque.removeFirst());
                             if(!deque.isEmpty()) sb.append(",");
                         }
                     } else {
                         // 역방향: 뒤에서부터 출력
                         while(!deque.isEmpty()) {
                             sb.append(deque.removeLast());
                             if(!deque.isEmpty()) sb.append(",");
                         }
                     }
                 }

                 sb.append("]");
                 System.out.println(sb.toString());
             }


        }

    }
}
