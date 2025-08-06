
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        //로프 넣기
        int[] rope = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            rope[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(rope);

        int max = 0;

        for(int i=0; i<N; i++){

            int weight = rope[i] * (N - i);
            
            max = Math.max(weight,max);

        }

        System.out.println(max);


    }
}

