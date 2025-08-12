

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());


        String[] arr = new String[3];

        for(int i=0 ; i<3; i++){
            arr[i] = br.readLine();
        }

        int result1 =0;
        int result2 =0;

        String s = "";

        // 숫자 계산
        for(int i=0; i<arr.length; i++){

            // 숫자 계산 변수 a
            int a = Integer.parseInt(arr[i]);

            // 2 문자계산 변수 s
            if(i<2){
                s = s+arr[i];
            }

            // 1,2 -계산
            if(i == 2){
                result1 -= a;
                result2 = Integer.parseInt(s) - a;
            }else{
                result1 += a;
            }



        }

        System.out.println(result1);
        System.out.println(result2);

    }
}
