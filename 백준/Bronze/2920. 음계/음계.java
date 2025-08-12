

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

//        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[9];

        boolean ascendCor = true;
        boolean descendCor = true;
        boolean mixed = false;

        for(int i=1 ; i<=8 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] != i){
                ascendCor = false;
            }

            if(arr[i] != 9-i){
                descendCor = false;
            }

            if(!ascendCor && !descendCor){
                mixed = true;
            }

        }

        String s;
        if(mixed){
            s = "mixed";
        }else if(ascendCor){
            s = "ascending";
        }else if(descendCor){
            s = "descending";
        }else{
            s ="풀이 오류";
        }

        System.out.println(s);

    }
}
