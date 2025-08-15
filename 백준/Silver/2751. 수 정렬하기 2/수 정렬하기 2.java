

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//
        int T = Integer.parseInt(br.readLine());

        int[] arr =new int[T];

        for(int i=0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int temp : arr){
            System.out.println(temp);
        }



    }
}
