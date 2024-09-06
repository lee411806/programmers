import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String numbers[] = str.split(" ");


        // 두 수 거꾸로 읽기
        int A = Integer.parseInt(new StringBuilder(numbers[0]).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(numbers[1]).reverse().toString());


        System.out.println(Math.max(A, B));
    }
}