import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer 사용하여 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // StringTokenizer에서 각 값 추출 및 long으로 변환
        long population = Long.parseLong(st.nextToken());
        long cm = Long.parseLong(st.nextToken());
        long countMax = Long.parseLong(st.nextToken());

        //최대 힙
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        while(population > 0){

            heap.add(Integer.parseInt(br.readLine()));

            population--;
        }


        int hammerCount = 0;
        boolean cmTall = false;

        while(countMax > 0){
            if (heap.peek() == 1) { // 키가 1이면 더 이상 줄일 수 없으므로 처리 중단
                break;
            }

            if(!(heap.peek() < cm)){
                int top = heap.poll() / 2;
                heap.add(top);
                hammerCount++;
            }else{
                cmTall = true;
                break;
            }

            countMax--;
        }


        if (heap.peek() < cm) {
            System.out.println("YES");
            System.out.println(hammerCount);
        } else {
            System.out.println("NO");
            System.out.println(heap.peek()); // 남은 거인 중 가장 큰 키 출력
        }
        
    
    }
}
