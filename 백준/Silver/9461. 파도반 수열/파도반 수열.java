/*
문제
파도반 수열

풀이
1.P(1) = P(2) = P(3) = 1 (초기 값)
2.P(n) = P(n-2) + P(n-3)
3.배열 만들어 DP로 활용
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long[] padovanDP = new long[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        padovanDP[1] = 1;
        padovanDP[2] = 1;
        padovanDP[3] = 1;

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //100넣어주면 오버플로우 발생
            System.out.println(p(n));
        }

    }

    public static long p(int n){

        if(padovanDP[n] != 0){
            return padovanDP[n];
        }else{
            padovanDP[n] = p(n-2) + p(n-3);
            return padovanDP[n];
        }
    }

}







