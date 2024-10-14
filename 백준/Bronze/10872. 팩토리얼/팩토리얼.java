
/*
문제
팩토리얼

입력 값
N!을 구하여라


풀이
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        System.out.println(factorial(N));

    }

    public static int factorial(int n) {

        if(n<=1){
            return 1;
        }else{
            return n*factorial(n-1);
        }

    }

}



