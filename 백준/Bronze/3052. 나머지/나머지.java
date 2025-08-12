

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[43];


        for(int i=1 ; i<=10 ; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = a % 42;

            arr[b]++;
        }

        int count =0;
        for(int temp: arr){
            if(temp != 0){
                count++;
            }
        }

        System.out.println(count);
    }
}
