

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

//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());

        int[] temp = new int[2];
        int max = Integer.MIN_VALUE;
        int count = 0;
        String line;

        while((line = br.readLine()) != null){

            count++;
            int a = Integer.parseInt(line);

            if(a > max){
                max = a;
                temp[0] = max;
                temp[1] = count;
            }
        }


        System.out.println(temp[0]);
        System.out.println(temp[1]);

    }
}
