

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();

        for(int i=1 ; i<=N; i++){
            deque.add(i);
        }

        List<Integer> list = new ArrayList<>();

        while(!deque.isEmpty()){


            for(int i=0 ; i<K-1; i++){
                deque.offer(deque.poll());
            }
            list.add(deque.poll());

        }

        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) { // 마지막 원소가 아니면만 공백 출력
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
