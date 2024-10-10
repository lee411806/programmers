
/*
문제
81개 자연수들중 최대 값 찾고 몇행 몇열인지 찾기

입력 값
9*9 board


풀이
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[9][9];

        int maxValue = Integer.MIN_VALUE;

        for (int i=0 ; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<9 ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > maxValue){
                    maxValue = board[i][j];
                }
            }
        }

        for (int i=0 ; i<9 ; i++){
            for (int j=0 ; j<9 ; j++){
                if (board[i][j] == maxValue){
                    System.out.println(board[i][j]);
                    System.out.println((i+1) + " " +(j+1));
                }
            }
        }


    }
}



