
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        //한번에 빠르게 받기 위해서 버퍼스트림 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Stack<Integer> stack = new Stack<>();


        // 찹조값 null 값 활용하는 것보다, 확실히 횟수 정해주는게 좋은듯
        String command;
        while ((command = br.readLine()) != null) {

            //각 조건에 따라 stack 처리
            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value);
            } else if (command.equals("pop")) {
                // 맨위 빼고 출력
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            } else if (command.equals("top")) {
                // 맨위 출력만
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        }
    }
}


