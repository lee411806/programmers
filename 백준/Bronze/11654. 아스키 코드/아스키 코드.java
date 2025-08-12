

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

        char c = br.readLine().charAt(0);
        int result = c - 'A'+'A';

        System.out.println(result);



    }
}
