import java.util.Scanner;

/*
문제
daldidalgo 가 n번 반복된 후 daldidan에서 끝난다.
둘 중 하나만 선택해서 실행
1. a-z 까지 1회당 1초
2. 위에서 문자열을 만든 것들중 복사하여 연속된문자열 붙여넣기 1초

풀이
1. daldia 때문에 반복수 헷갈려서 그냥 daldidan으로 생각
2. 처음 문자찍을 때 daldidalgo와 마지막 daldidan과 반복만 생각해주면 됨
3. 짝수일 때 daldidan은 daldida + n 으로 횟수 2 , 홀수 일때 daldida 가 반복수에 포함되어 n만 count하여 횟수 1
4. 따라서 짝수일 때는 N에서 /2가 1이 될때까지 repeat count , 홀수는 반복수에 daldida가 포함되어 반복수+1 , last에 daldida가 빠져 last-1
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int first = 8;
        int last = 2;
        int repeatCount=0;

        boolean nOdd = false;

        while(N>1){
            if(N%2 ==0){
                N/=2;
                repeatCount++;
            }else if(N%2==1){
                nOdd = true;
                N/=2;
                repeatCount++;
            }
        }

        if(nOdd){
            repeatCount++;
            last-=1;
        }

        System.out.println(first + repeatCount + last);
    }
}
