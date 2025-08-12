

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

        int[][] arr = new int[N][2];

        for(int i=0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0 ; j<2; j++){
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for(int i=0; i < N; i++){

                int sum = arr[i][0] + arr[i][1];
                System.out.println(sum);

        }

    }
}
