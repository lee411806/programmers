
/*
문제
1. 숫자 카드 N개 중 정수 M개가 주어짐
2. 이 수가 적혀있는 카드를 상근이는 몇개 가지고 있는가?

입력 값
총 숫자카드 개수
숫자 카드 목록
상근이가 가지고 있는 숫자카드 개수
상근이가 가지고 있는 숫자카드

풀이
HashMap key : 숫자  value : 숫자의 수

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: 숫자 카드 개수 N
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄 입력: 숫자 카드 목록
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        // 숫자 카드를 map에 추가 (숫자: 빈도수)
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());  // 한 번만 가져와서 변수에 저장
            map.put(card, map.getOrDefault(card, 0) + 1);  // 해당 카드가 이미 있으면 개수 증가, 없으면 1로 설정
        }

        // 세 번째 줄 입력: 찾아야 할 숫자 카드의 개수 M
        int M = Integer.parseInt(br.readLine());

        // 네 번째 줄 입력: 상근이가 찾아야 할 숫자 카드들
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st1.nextToken());
            // map에서 해당 숫자의 개수를 가져와 출력 (없으면 0 출력)
            sb.append(map.getOrDefault(query, 0)).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}


