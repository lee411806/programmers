
/*
문제
B에 있는 수 재배열 하지 않고 합을 최소로 만들기

풀이



 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        int[] a = new int[length];
        List<Integer> b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            b.add(Integer.parseInt(st2.nextToken()));
        }

        Arrays.sort(a);
        // 내림차순 정렬

        int result = 0;

        for(int i=0 ; i<length ; i++){
            int maxIndex = 0;


            for(int j=1; j < b.size() ; j++){
                if(b.get(j)>b.get(maxIndex)){
                    maxIndex = j;

                }
            }

            result += b.get(maxIndex) * a[i];
            b.remove(maxIndex);

        }

        System.out.println(result);

    }

}
