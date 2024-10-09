
/*
문제
N개의 정수에서 최솟값과 최댓값을 구하는 프로그램

입력 값
N개의 정수
정수

풀이
max, min통해 구한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }

        System.out.println(min+" "+max);
    }
}



