
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i=1; i<=N;i++){
                queue.offer(i);
            }
            int result =0;
            boolean flag = false;
            while(!queue.isEmpty()){
                if(queue.size() == 1){
                    result = queue.peek();
                }
                if(!flag){
                    queue.poll();
                    flag = true;
                }else{
                    queue.offer(queue.poll());
                    flag = false;
                }
            }

        System.out.println(result);



    }

}
