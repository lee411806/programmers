
/*
문제
왼쪽아래 점 (0,0) , 오른쪽 위의 점 (w,h)
위 두개의 점으로 직사각형을 만들고 직사각형 안에 현재 위치는 (x,y)이다.
x,y에서 각 변으로가는 최소 값은?

입력 값
x,y,w,h

풀이
각 변으로 가는 길이 구하고 최솟 값 구한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] rectangle = new int[4];
        rectangle[0] = x;
        rectangle[1] = h - y;
        rectangle[2] = w - x;
        rectangle[3] = y;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            min= Math.min(rectangle[i], min);
        }

        System.out.println(min);
    }
}



