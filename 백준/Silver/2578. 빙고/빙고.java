
/*
문제
몇번 째 수를 부를 때 빙고를 외칠 수 있는지

입력 값
첫째 줄부터 다섯째 줄까지 빙고판
여섯째 줄부터 열째 줄까지 사회자가 부르는 수

풀이
1. 빙고판 입력
2. 빙고가 되는 경우의 수 만들어서 빙고 count 세기
3. 숫자 count 세면서 빙고 count가 3이되면 count 반환

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board= new int[5][5];

        for (int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int resultCount =0;
        boolean bingoFlag = false;
        boolean[][] checked = new boolean[5][5];
        // 숫자 카운팅 하면서 , 숫자 마크, 빙고체크
        for (int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                int currentNum = Integer.parseInt(st.nextToken());
                resultCount++;
                mark(board,checked, currentNum); // 숫자 불려진거 마킹

                if(bingo(checked) >= 3){
                    System.out.println(resultCount);
                    bingoFlag = true;
                    break;
                }

            }
            if(bingoFlag){break;}
        }



    }

    public static void mark(int[][] board, boolean[][] checked, int currentNum){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (board[i][j] == currentNum){
                    checked[i][j] = true;
                }
            }
        }
    }

    public static int bingo(boolean[][] checked){
        int bingoCount=0;

        //rowbingo
        for (int i=0; i<5; i++){
            boolean rowBingo = true;
            for (int j=0; j<5; j++){
                if(checked[i][j]==false){
                     rowBingo = false;
                     break;
                }
            }
            if(rowBingo==true){bingoCount++;}
        }

        //colBingo

        for (int i=0; i<5; i++){
            boolean colBingo = true;
            for (int j=0; j<5; j++){
                if(checked[j][i]==false){
                    colBingo = false;
                    break;
                }
            }
            if(colBingo==true){bingoCount++;}
        }

        //왼쪽에서 오른쪽 대각선 빙고

        boolean leftDiagonal = true;
        for (int i=0; i<5; i++){
            if(checked[i][i]==false){
                leftDiagonal = false;
                break;
            }
        }
        if(leftDiagonal==true){bingoCount++;}


        boolean rightDiagonal = true;
        for (int i=0; i<5; i++){
            if(checked[i][4-i]==false){
                rightDiagonal = false;
                break;
            }
        }
        if(rightDiagonal==true){bingoCount++;}

        return bingoCount;
    }

}



