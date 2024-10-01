/*
문제
양수 N에서 30배수가 되는 가장 큰 값
단 N안의 수들을 섞을 수 있다.

풀이
1.30의 배수임으로 맨뒤에 0
2. 서로 0을 제거해주면 3의 배수만 판별하면 됨
3. 오름차순으로 정렬하고 3의 배수인지 확인해서 맞는지 판별 -> 자리 위치 상관 없이 각자리의 수의 합이 3의 배수이면 무조건 3의 배수
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] n = sc.nextLine().toCharArray();

        Arrays.sort(n);

        int sum =0;
        for(int i=0 ; i<n.length ; i++){
             int temp = n[i] - '0';
             sum += temp;
        }

        if(sum%3==0 && n[0] == '0'){
            for(int i=n.length-1 ; i>=0; i--){
                System.out.print(n[i]);
            }
        }else{
            System.out.println(-1);
        }



    }
}



