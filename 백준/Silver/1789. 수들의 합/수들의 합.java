import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

       long S = Long.parseLong(st.nextToken());
        
        int n =1;
        int count =0;
        long sum =0;

        while(true){

            sum +=n;
            if(sum>S){
                break;
            }
            n++;
            count++;

        }
        System.out.println(count);

    }
}
