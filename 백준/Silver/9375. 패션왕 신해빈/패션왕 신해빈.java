import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int count = Integer.parseInt(br.readLine());

        while (count > 0) {

            // 키로 값을 빠르게 조회, 다양한 타입 받아 들일 수 있음
            HashMap<String, Integer> map = new HashMap<>();

            // 옷 종류
            int clothesCount = Integer.parseInt(br.readLine());

            while (clothesCount > 0) {
                // 종류 만 뽑아서 map에 넣어줌 ( 의상을 입을 수 있느니 경우의 수만 구해주면 되기 때문에)
                String clothesKind = br.readLine().split(" ")[1];
                
                // key 값 중복이면 value에 경우 1 더해주고 아니면 key value 넣어줌
                if (map.containsKey(clothesKind)) {
                    map.put(clothesKind, map.get(clothesKind) + 1);
                } else {
                    map.put(clothesKind, 1);
                }


                clothesCount--;
            }
            
            // key값 즉 옷 종류들의 경우의 수 서로 곱해줌 -> 알몸의 경우의 수 빼줌
            int result = 1;

            for (int value : map.values()) {
                // 각 종류별로 아무것도 안 입었을 때 의 경우를 더해줌 
                result *= (value + 1);
            }

            System.out.println(result - 1);

            count--;
        }


    }
}
