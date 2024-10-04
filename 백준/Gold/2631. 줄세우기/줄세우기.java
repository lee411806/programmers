/*
문제
아이들의 위치를 옮기는데 옮기는 아이들의 수를 최소화

풀이
1.원래 순서대로 있던 배치에서 벗어난 애들만 옮겨주기
2. 원래 순서대로 있던 배치 -> list -> dp
3.최소 아이들을 옮겨야하는수 -> 전체 아이의 수 - 원래 순차적으로 있던 아이의 수(lis)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];

        for(int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
//            System.out.print(children[i] + " ");
        }

        int lisDP[] = new int[N];
        Arrays.fill(lisDP, 1);

        int stayChildren = lis(children,lisDP,N);

        //최소 아이들을 옮겨야하는수 -> 전체 아이의 수 - 원래 순차적으로 있던 아이의 수(lis)
        System.out.println(N-stayChildren);
    }

    public static int lis(int[] children, int[] lisDP, int N){

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(children[i] > children[j]) {
                    lisDP[i] = Math.max(lisDP[i], lisDP[j] + 1);
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(lisDP[i] > maxVal) {
                maxVal = lisDP[i];
            }
        }

        return maxVal;
    }
}






