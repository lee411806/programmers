

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

   static int N;

   static List<Integer>[] listArr;
   static boolean visited[];
   static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());


        N = Integer.parseInt(br.readLine());

        listArr = new List[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=1 ;i<=N; i++){
            listArr[i] = new ArrayList<>();
        }



        for(int i=0; i<N-1 ; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
                listArr[b].add(a);
                listArr[a].add(b);
        }

        bfs();

        for(int i=2; i<parent.length;i++){
            System.out.println(parent[i]);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){

            int current = queue.poll();

           for(int next : listArr[current]){
               if(!visited[next]){
                   parent[next] = current;
                   visited[next] = true;
                   queue.add(next);
               }
           }
        }
    }

}
