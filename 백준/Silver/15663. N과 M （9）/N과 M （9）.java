

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int M;
   static int N;

   static int[] arr;
   static int[] arr2;
   static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        arr2 = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1 ;i<=N;i++){
            arr2[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr2);

        dfs(1, 0);
    }

    static void dfs(int start, int depth){

       if(depth == M){
           for(int i=0; i<M;i++){
                   System.out.print(arr[i]+" ");
           }System.out.println();
           return;
       }


       Set<Integer> used = new HashSet<>();

       for(int i= 1 ; i <= N; i++){

           if(used.contains(arr2[i])){
               continue;
           }

           if(!visited[i]) {
               visited[i] = true;
               used.add(arr2[i]);
               arr[depth] = arr2[i];
               dfs(i+1, depth+1);
               visited[i] = false;
           }

       }
    }
}
