import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] compress = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 복사 후 정렬
        compress = Arrays.copyOf(arr, n);
        Arrays.sort(compress);  // TimSort를 사용하여 O(n log n) 보장

        // 좌표 압축을 위한 Map
        Map<Integer, Integer> map = new HashMap<>();
        int compressionValue = 0;

        // 정렬된 배열에 대해 압축 값 부여
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(compress[i])) {  // 중복된 값은 건너뜀
                map.put(compress[i], compressionValue++);
            }
        }

        // 원래 배열의 순서에 맞춰 압축된 값을 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
