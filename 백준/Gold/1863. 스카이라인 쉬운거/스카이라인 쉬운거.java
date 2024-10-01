/*
문제
스카이 라인을 보고 최소 건물의 수 구하기

입력 값
입력하는 값의 수 n
x,y 좌표

풀이
stack에 집어 넣고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();


        int result = 0;
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); //x좌표는 필요없다.
            int y = Integer.parseInt(st.nextToken());

            //건물이 높아지면 건물 수 늘어난다.
            //건물이 낮아지면 늘어날 수도 안늘어 날 수 도 있음 --> 스택에 중복 값 방지하면서 넣으면 됨


            // 건물 높이가 0이면 스택을 비움
            if (y == 0) {
                stack.clear();
                continue;
            }

            // 스택이 비어있으면 첫 건물을 스택에 추가
            if (stack.isEmpty()) {
                stack.push(y);
                result++;
            } else {
                // 스택의 top이 현재 건물보다 높으면 제거
                while (!stack.isEmpty() && stack.peek() > y) {
                    stack.pop();
                }
                // 스택에 같은 높이가 없으면 새 건물로 간주하고 추가
                if (stack.isEmpty() || stack.peek() != y) {
                    stack.push(y);
                    result++;
                }
            }

        }

        // -> 예시는 통과하지만 모든 경우의 수 처리못함
//        int temp = stack.pop();
//        result +=1; // 처음 건물 더해줌
//        while (!stack.isEmpty()) {
//            if (stack.peek() > temp) {
//                result += 1;
//            }
//            temp = stack.pop();
//        }
//
        System.out.println(result);

    }
}



