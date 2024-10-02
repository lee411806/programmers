/*
문제
1.문자열 3개의 LCS(연속된 문자의 수)의 길이를 구하여라
2. lcs : 문자가 연속적으로 나타날 필요는 없지만 순서는 유지되어야 한다.
3. 순차적으로 비교하면서 공통된 부분의 수열의 길이 찾기

풀이
1. 세 문자열 중 어느하나라도 0이면 lsc : 0
2. 문자가 모두 같은 경우, lcs의 공통수열에 포함시킬 수 있음 그래서 수열에 +1
3. 문자가 다른 경우, 경우의 수가 각 문자열의 수를 제외시킨 상태에서 ...

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] x = br.readLine().toCharArray();
        char[] y = br.readLine().toCharArray();
        char[] z = br.readLine().toCharArray();

        // DP 테이블을 초기화 (-1로 초기화해서 아직 계산되지 않은 상태를 나타냄)
        int[][][] dp = new int[x.length + 1][y.length + 1][z.length + 1];
        for (int[][] arr : dp) {
            for (int[] innerArr : arr) {
                Arrays.fill(innerArr, -1); // 아직 계산되지 않은 상태는 -1로 설정
            }
        }

        // 세 개의 문자열을 넘겨주어 최장 공통 부분 수열의 길이를 계산
        int lcsLength = lcs(x, y, z, x.length, y.length, z.length, dp);
        System.out.println(lcsLength);
    }

    // 재귀적으로 LCS 구하는 함수 + 메모이제이션 적용
    public static int lcs(char[] x, char[] y, char[] z, int xLen, int yLen, int zLen, int[][][] dp) {
        // 기저 조건: 문자열 중 하나라도 길이가 0이면, LCS는 0
        if (xLen == 0 || yLen == 0 || zLen == 0) {
            return 0;
        }

        // 이미 계산된 값이 있으면 그 값을 반환 (메모이제이션 적용)
        if (dp[xLen][yLen][zLen] != -1) {
            return dp[xLen][yLen][zLen];
        }

        // 현재 위치의 문자가 세 문자열에서 모두 같을 때
        if (x[xLen - 1] == y[yLen - 1] && y[yLen - 1] == z[zLen - 1]) {
            dp[xLen][yLen][zLen] = lcs(x, y, z, xLen - 1, yLen - 1, zLen - 1, dp) + 1;
        } else {
            // 같지 않을 때 각각의 문자열에서 문자를 하나씩 줄여가며 세 가지 선택을 모두 시도하고, 그 중 최대값을 선택
            dp[xLen][yLen][zLen] = Math.max(
                    Math.max(lcs(x, y, z, xLen - 1, yLen, zLen, dp), lcs(x, y, z, xLen, yLen - 1, zLen, dp)),
                    lcs(x, y, z, xLen, yLen, zLen - 1, dp)
            );
        }

        return dp[xLen][yLen][zLen]; // 계산된 값을 반환
    }
}




