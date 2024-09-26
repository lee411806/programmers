import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //버퍼로 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int count = Integer.parseInt(br.readLine());




        // 가장 가치가 큰 선물 -> 최대 값 부터 나와야 함 -> 최대 힙
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

        while(count > 0){
            // 0이 아닌 선물을 줄 때 토큰 으로 힙에 넣어줌
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("0")){
                if(heap.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(heap.poll());
                }
            }else{
                while(st.hasMoreTokens()){
                    heap.add(Integer.parseInt(st.nextToken()));
                }
            }



            count--;
        }



    }
}
