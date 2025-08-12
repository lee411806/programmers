

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char c;

        if(N < 60){
            c = 'F';
        } else if (N < 70) {
            c = 'D';
        } else if (N < 80) {
            c = 'C';
        } else if (N < 90) {
            c = 'B';
        } else if (N <= 100) {
            c = 'A';
        }else{
            c='0';
            System.out.println("잘못된 입력");
        }

        System.out.println(c);


    }
}
