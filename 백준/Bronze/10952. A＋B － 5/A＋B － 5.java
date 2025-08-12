
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(st.nextToken());

//        int[][] arr = new int[N][2];

        String line;
        while((line = br.readLine()) != null){

            StringTokenizer st1 = new StringTokenizer(line);
            int sum =0;
            for(int j=0 ; j<2; j++){
                int a = Integer.parseInt(st1.nextToken());
                sum += a;
            }

            if(sum != 0){
                System.out.println(sum);
            }
        }


    }
}
