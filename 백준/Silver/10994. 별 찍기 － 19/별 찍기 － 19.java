import java.util.Scanner;

public class Main {

    public static int mapping(int n){

        return 1 + (n - 1) * 4;  // 첫 번째 항이 1이고, 공차가 4인 등차수열

    }


    public static void main(String[] args) {
        //입력 값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        n = mapping(n);

        //나선형 방향 결정
        int rowRight = n - 1;
        int rowLeft = 0;
        int colUp = 0;
        int colDown = n - 1;


        //while 문 종료시켜줄 count 생성
        int count = 0;

        //모양을 담을 배열 생성
        String[][] arr = new String[n][n];


        // 나선형으로 채울 때 while 루프를 사용
        while (count < n * n) {

            // 좌 -> 우 (rowLeft에서 rowRight까지)
            for (int j = rowLeft; j <= rowRight; j++) {
                arr[colUp][j] = "*";  // 위쪽 행에서 좌 → 우로 별을 찍음
                count++;
            }
            colUp++;  // 위쪽 경계를 한 줄 내려줌

            // 상 -> 하 (colUp에서 colDown까지)
            for (int i = colUp; i <= colDown; i++) {
                arr[i][rowRight] = "*";  // 오른쪽 열에서 상 → 하로 별을 찍음
                count++;
            }
            rowRight--;  // 오른쪽 경계를 왼쪽으로 한 줄 이동

            // 우 -> 좌 (rowRight에서 rowLeft까지)

            for (int j = rowRight; j >= rowLeft; j--) {
                arr[colDown][j] = "*";  // 아래쪽 행에서 우 → 좌로 별을 찍음
                count++;
            }
            colDown--;  // 아래쪽 경계를 한 줄 위로 이동


            // 하 -> 상 (colDown에서 colUp까지)

            for (int i = colDown; i >= colUp; i--) {
                arr[i][rowLeft] = "*";  // 왼쪽 열에서 하 → 상으로 별을 찍음
                count++;
            }
            rowLeft++;  // 왼쪽 경계를 오른쪽으로 한 줄 이동


            // 공백 출력


            // 좌 -> 우 (rowLeft에서 rowRight까지)
            for (int j = rowLeft; j <= rowRight; j++) {
                arr[colUp][j] = " ";  // 위쪽 행에서 좌 → 우로 별을 찍음
                count++;
            }
            colUp++;  // 위쪽 경계를 한 줄 내려줌

            // 상 -> 하 (colUp에서 colDown까지)
            for (int i = colUp; i <= colDown; i++) {
                arr[i][rowRight] = " ";  // 오른쪽 열에서 상 → 하로 별을 찍음
                count++;
            }
            rowRight--;  // 오른쪽 경계를 왼쪽으로 한 줄 이동

            // 우 -> 좌 (rowRight에서 rowLeft까지)

            for (int j = rowRight; j >= rowLeft; j--) {
                arr[colDown][j] = " ";  // 아래쪽 행에서 우 → 좌로 별을 찍음
                count++;
            }
            colDown--;  // 아래쪽 경계를 한 줄 위로 이동


            // 하 -> 상 (colDown에서 colUp까지)

            for (int i = colDown; i >= colUp; i--) {
                arr[i][rowLeft] = " ";  // 왼쪽 열에서 하 → 상으로 별을 찍음
                count++;
            }
            rowLeft++;  // 왼쪽 경계를 오른쪽으로 한 줄 이동


        }

        // 2차원 배열을 행과 열로 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();  // 한 행이 끝나면 줄바꿈
        }
    }

}