import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < line; i++) {

            // 입력을 한 번 읽어서 이름과 숫자로 분리
            String[] temp = br.readLine().split(" ");
            String name = temp[0];  // 이름
            int value = Integer.parseInt(temp[1]);  // 숫자


            // 이름이 이미 존재하면 기존 값에 더하기, 아니면 새로 추가
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + value);  // 기존 값에 더함
//                System.out.println(map.get(name));
            } else {
                map.put(name, value);  // 새로 추가
            }



        }

        boolean five = false;

        // for-each 문으로 map의 값들을 순회
        for (int value : map.values()) {
            if (value == 5) {
                five = true;
                break;  // 5의 배수가 발견되면 더 이상 확인하지 않고 종료
            }
        }

        if (five) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }




    }
}
