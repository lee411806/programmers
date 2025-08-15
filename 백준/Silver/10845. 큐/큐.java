

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

            Deque<Integer> queue= new LinkedList<>();

            while(N-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num;
                String order = st.nextToken();

                if(order.equals("push")){
                    num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    continue;
                }

                int result = -10;

                if(order.equals("pop")){
                    if(!queue.isEmpty()){
                        System.out.println(queue.poll());
                        continue;
                    }else{
                        result = -1;
                    }
                }

                if(order.equals("size")){
                    result = queue.size();
                }


                if(order.equals("empty")){
                    if(queue.isEmpty()){
                        result = 1;
                    }else{
                        result = 0;
                    }
                }

                if(order.equals("front")){
                    if(!queue.isEmpty()){
                        result = queue.peekFirst();
                    }else{
                        result =-1;
                    }
                }

                if(order.equals("back")){
                    if(!queue.isEmpty()){
                        result = queue.peekLast();
                    }else{
                        result =-1;
                    }
                }


                System.out.println(result);
            }




    }
}
