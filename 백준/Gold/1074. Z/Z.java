

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int N;
   static int r;
   static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

       System.out.println(dfs(N,r,c));

    }

    static int dfs(int N, int r, int c){
        if(N==0) return 0;

        int mid = 1 << (N-1);
        int area = mid * mid;

        if(r<mid && c<mid){
            return dfs(N-1, r,c);

        }else if(r<mid && c>=mid){
            return area + dfs(N-1, r, c-mid);
        }else if(r>=mid && c<mid){
            return area * 2 + dfs(N-1, r-mid, c);
        }else{
            return area * 3 + dfs(N-1, r-mid, c-mid);
        }


    }

}
