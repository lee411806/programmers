

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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

       if(M >= 45){
           M -= 45;
       }else{
           M += 60;
           M -= 45;
           if(H == 0){
               H = 23;
           }else{
               H -= 1;
           }
       }

       System.out.println(H+" "+ M);

    }
}
