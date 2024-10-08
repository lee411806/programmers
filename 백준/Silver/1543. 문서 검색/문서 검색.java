
/*
문제
단어가 최대 몇 번 중복되지 않게 등장하는지

입력 값
문서
검색하고 싶은 단어

풀이
패턴 매칭 -> KMP 알고리즘

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int dN = document.length();
        int wN = word.length();

        int[] lps = lps(word); // 패턴에 대한 LPS 배열을 구함

        int i = 0; // 문서의 인덱스
        int j = 0; // 패턴의 인덱스
        int count = 0; // 단어가 등장한 횟수

        while (i <= dN - wN) { // 더 이상 패턴을 찾을 수 없을 때까지
            if (document.startsWith(word, i)) {
                // 패턴이 문서의 i 위치에서 시작된다면
                count++; // 카운트를 증가시키고
                i += wN; // 중복을 피하기 위해 단어 길이만큼 건너뜀
            } else {
                i++; // 일치하지 않으면 한 칸씩 이동
            }
        }

        System.out.println(count);
    }

    // LPS 배열을 구하는 함수
    public static int[] lps(String word) {
        int wordLen = word.length();
        int[] lps = new int[wordLen];
        int len = 0;
        int i = 1;

        lps[0] = 0; // 첫 번째 문자의 lps는 항상 0

        while (i < wordLen) {
            if (word.charAt(i) == word.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}



