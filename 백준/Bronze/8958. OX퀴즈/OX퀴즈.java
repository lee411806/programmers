

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            char[] c = br.readLine().toCharArray();

            int score = 0;
            int sum =0;

            for(int i=0; i<c.length;i++){
                if(c[i] == 'O'){
                    score++;
                    sum+=score;
                }else{
                    score =0;
                }
            }

            System.out.println(sum);
        }

    }
}
