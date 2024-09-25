import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력 값 한 번에 버퍼로 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 커서를 기준으로 왼쪽 오른쪽 나누고 스택으로 만들어줌
        Stack<String> cursorLeft = new Stack<>();
        Stack<String> cursorRight = new Stack<>();

        //명령어가 수행되기 전 커서는 문장위 맨뒤 위치 = 왼쪽 커서 스택에 넣어줌
        char[] c = br.readLine().toCharArray();

        for (int i = 0; i < c.length; i++) {
            cursorLeft.push(String.valueOf(c[i]));
        }

        String command;
        int count = Integer.parseInt(br.readLine());
        while (count > 0) {
               command = br.readLine();
            if (command.equals("L")) {
                if (!cursorLeft.isEmpty()) {
              //      System.out.println("동작중 L");
                    cursorRight.push(cursorLeft.pop());
                }
            } else if (command.equals("D")) {

                if (!cursorRight.isEmpty()) {
              //      System.out.println("동작중 D");
                    cursorLeft.push(cursorRight.pop());

                }


            } else if (command.equals("B")) {

                if (!cursorLeft.isEmpty()) {
               //     System.out.println("동작중 B");
                    cursorLeft.pop();

                }
            } else if (command.startsWith("P")) {
                cursorLeft.push(command.substring(2)); // split 사용 대신 substring 사용
          //      System.out.println("동작중 p");
            }

            count--;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //커서 왼쪽 출력
        for(String element : cursorLeft) {
            bufferedWriter.write(element);
        }

        //커서 오른쪽 출력
        while (!cursorRight.isEmpty()) {
            bufferedWriter.write(cursorRight.pop());
        }

        // 모든 출력이 끝난 후 flush() 호출하여 버퍼 비우기
        bufferedWriter.flush();
        // BufferedWriter 닫기
        bufferedWriter.close();

    }


}
