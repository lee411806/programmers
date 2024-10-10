
/*
문제

입력 값
행렬의 크기 N M
행렬 A원소
행렬 B의 원소

풀이
둘이 더한 값을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[N][M];
        int[][] arrB = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrA[i][j] = Integer.parseInt(st1.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrB[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int[][] sum = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum[i][j] = arrA[i][j] + arrB[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }


    }
}



