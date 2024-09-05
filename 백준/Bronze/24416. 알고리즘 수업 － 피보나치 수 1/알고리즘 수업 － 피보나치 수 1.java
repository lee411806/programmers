import java.util.Scanner;

public class Main {

    //재귀함수 내에 count 를 뽑아내기 어려움으로 인한 count 변수 전역 설정
    //재귀함수 count
    static int rCount =0;

    public static void main(String[] args) {

        //입력 받을 값
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        //재귀함수 호출
        sRecursion(n);

        //동적 프로그래밍 count 가져오기
        int dCount = dProgramming(n);

        System.out.println(rCount);
        System.out.println(dCount);

    }

    //재귀
    public static int sRecursion(int n) {
      



        if (n == 1 || n == 2) {
            //중요 : 코드가 몇번 실행되었는지 알기 위해서는 1이 몇번 더해졌는지 알면 된다.
            rCount++;
            return 1;
        } else {
            return sRecursion(n - 1) + sRecursion(n - 2);

        }

    }

//동적 프로그램
public static int dProgramming(int n) {

    //n이 2이하일 경우 바로 반환
    if (n < 2) {
        return 1;
    }

    int[] arr = new int[n];
    int count = 0;

    arr[0] = 1;
    arr[1] = 1;

    for (int i = 2; i < n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
        count++;
    }


    return count;

}

}