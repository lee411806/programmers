

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[] numCount = new int[10];

        int multiple = a*b*c;
        String s = String.valueOf(multiple);


        for(int i=0; i< s.length() ;i++){

            int temp = multiple % 10;
            multiple /= 10;

            numCount[temp]++;

        }

        for(int temp: numCount){
            System.out.println(temp);
        }

    }
}
