

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

        int[][] arr =new int[T][2];

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        Arrays.sort(arr, (a,b) ->
        {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });


        for(int temp[] : arr){
            for(int temp2 : temp){

                System.out.print(temp2+" ");
            }
            System.out.println();
        }



    }
}
