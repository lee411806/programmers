

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

            int count=0;

            while(N > 0){

                if(N == 2 || N == 1){
                    count = -1;
                    break;
                }


                if (N % 5 == 0) {
                    count += N/5;
                    break;
                }


                N -= 3;
                count++;

            }

            System.out.println(count);


    }

}
