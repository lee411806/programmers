import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());


        PriorityQueue<Long> queue = new PriorityQueue<>();

        while (count > 0) {


            Long x = Long.parseLong(br.readLine());

            if (x == 0) {

                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else if (x > 0) {
                queue.add(x);
            }

            count--;

        }

    }
}
