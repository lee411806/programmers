/*
문제
같은  반 이었던 학생 수가 가장 많았던 학생

풀이
1. 반복문으로 예제를 classes 배열에 넣음
2. 모든 학생을 비교를 2중반목문으로 표현하는데 반복문 하나를 안에 더 넣어 반별로 중복된 수를 비교할 수 있게 한다.
3. 반이 겹치면 count배열에 겹친학생들 +1
4. 최대값 뽑아서 index값이 captain
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] classes = new int[n][5];

        //학생들 반 정보 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //학생별 같은 반이었던 적이 있다면 count
        int[] count = new int[n];


        // 모든 학생을 순회하면서 비교
        for (int i = 0; i < n; i++) {  // 학생 i
            for (int j = 0; j < n; j++) {  // 학생 j
                if (i == j) continue;  // 자신과는 비교하지 않음
                for (int m = 0; m < 5; m++) {  // 5학년 동안의 반을 비교
                    if (classes[i][m] == classes[j][m]) {  // 같은 반이었는지 확인
                        count[i]++;  // 같은 반이었다면 카운트 증가
                        break;  // 한번 같은 반이었다면 그 학년은 더 볼 필요 없으므로 break
                    }
                }
            }
        }

        // 가장 많은 친구를 가진 학생 찾기
        int captain = -1;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                captain = i;
            }
        }
        // 학생이 인덱스로 나타내어져 0부터시작함으로 1더함
        System.out.println(captain + 1);
    }
}




