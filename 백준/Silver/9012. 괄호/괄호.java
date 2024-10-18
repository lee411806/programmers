import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true; // VPS인지 판단하는 플래그

            for(int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                if(ch == '(') {
                    stack.push(ch); // 여는 괄호는 스택에 추가
                } else if(ch == ')') {
                    if(stack.isEmpty()) { // 닫는 괄호가 나왔는데 스택이 비어있으면 VPS가 아님
                        isVPS = false;
                        break;
                    }
                    stack.pop(); // 닫는 괄호에 대해 여는 괄호를 제거
                }
            }

            // 문자열이 끝났을 때 스택이 비어있지 않으면 VPS가 아님
            if(!stack.isEmpty()) {
                isVPS = false;
            }

            // 결과 출력
            if(isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
