
/*
문제
파보나치 수

입력 값
N번째 파보나치 수를 구하여라


풀이
기저조건 : fibo(0) =0 , fibo(1) = 1
점화식 : fibo(n)= fibo(n-1) + fibo(n-2)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        System.out.println(fibonacci(N));

    }

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) +fibonacci(n-2);
        }

    }

}



