
/*
문제


풀이
B에 있는 수 재배열 하면 너무 쉬워짐


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        int[] a = new int[length];
        Integer[] b = new Integer[length];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(a);
        // 내림차순 정렬
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = length; i < length; i++) {
            System.out.println(b[i]);
        }

        int result =0;
        for(int i=0 ; i<length ; i++){
            result += a[i] * b[i];
        }

        System.out.println(result);

    }

}
