
/*
문제
동전은 무한정 가지고 있고 거스름돈이 n인 경우
최소 동전의 개수가 몇 개인가?

입력값
거스름돈 액수

풀이
5원을 최대한 다쓰면서 나머지 돈이 2원짜리에 부합해야 한다.

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = -1;  // 거슬러줄 수 없으면 -1 출력

        // 5원짜리를 최대한 사용하고 남은 금액이 2원으로 나눠떨어지는지 확인
        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - (i * 5);
            if (remaining % 2 == 0) {
                count = i + (remaining / 2);  // 5원짜리 동전 개수 + 2원짜리 동전 개수
                break;
            }
        }

        System.out.println(count);
    }
}


