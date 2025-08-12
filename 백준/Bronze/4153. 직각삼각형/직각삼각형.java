

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null){
            int[] arr = new int[3];

            StringTokenizer st = new StringTokenizer(line);


            for(int i=0 ; i<3 ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int max = arr[2];


            if(max * max == arr[1] * arr[1] + arr[0] * arr[0]){
                if(max ==0){

                }else{
                    System.out.println("right");
                }
            }else{
                System.out.println("wrong");
            }

        }



    }
}
