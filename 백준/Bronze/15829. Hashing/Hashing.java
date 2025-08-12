

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//      StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int r = 31;
        int M = 1234567891;

        char[] arr = br.readLine().toCharArray();

        long sum =0;
        for(int i=0; i<arr.length; i++){
            int temp = arr[i] -'a' + 1;
            for(int j=0 ; j<i ;j++){
                temp *= r;
            }
            sum += temp;
        }


        long result = sum/M;

        System.out.println(sum);
    }
}
