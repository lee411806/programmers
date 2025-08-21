

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());  // 배열 크기 (4)
//        int m = Integer.parseInt(st.nextToken());  // 쿼리 개수 (3)
//
//        // n×n 배열 입력받기
//        int[][] arr = new int[n][n];
//        for(int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < n; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
        char[] cArr = br.readLine().toCharArray();
        char[] cArr2 = br.readLine().toCharArray();

        int[][] dp = new int[cArr.length+1][cArr2.length+1];

        for(int i=1 ; i<= cArr.length;i++){
            for(int j=1 ; j<=cArr2.length;j++){
                if(cArr[i-1] == cArr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[cArr.length][cArr2.length]);




    }
}
