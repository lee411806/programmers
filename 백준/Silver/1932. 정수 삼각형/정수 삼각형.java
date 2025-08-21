

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] listArr;
    static int sum =0;
static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        A = Integer.parseInt(st.nextToken());
//        B = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());

        listArr = new List[n];
        for(int i=0 ; i<n ; i++){
            listArr[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1;j++){
                listArr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

//        for(List<Integer> temp : listArr){
//            for(int temp2 : temp){
//                System.out.print(temp2 + " ");
//            }
//            System.out.println();
//        }
        dp = new int[n][n];

        for(int j=0 ; j<n; j++){
            dp[n-1][j] = listArr[n-1].get(j);
        }


        for(int i = n-2; i>=0; i--){
            for(int j=0; j<=i ; j++){
                dp[i][j] = listArr[i].get(j)  + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);

    }

}
