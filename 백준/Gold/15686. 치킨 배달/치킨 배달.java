/*
문제
nxn도시 , 도시의 칸 (r,c)
치킨거리 |r1-r2| + |c1-c2|
m개의 치킨집이 폐업을 하는데 남은 치킨집들은 치킨거리가 최소가 되어야 함
남은 치킨집들의 치킨 거리

풀이
1. 표를 배열에 넣기
2. 배열을 돌리면서 만약 집이라면 근처 치킨집 최단 거리 구해서 Map의 key에 넣고 최단거리에 count하기
3. 문제에서 폐업 지점수를 주니 최단거리가 낮은 가게부터 m에서 뺀다.
4. m>0 조건에 만족하는 마지막 최단거리 찾고 그 최단거리인 도시들만 치킨거리 계산
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M; // 도시 크기와 남길 치킨집의 수
    static List<int[]> houses = new ArrayList<>(); // 집 좌표 리스트
    static List<int[]> chickens = new ArrayList<>(); // 치킨집 좌표 리스트
    static int minChickenDistance = Integer.MAX_VALUE; // 최소 치킨 거리 저장 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 크기 N
        M = Integer.parseInt(st.nextToken()); // 남길 치킨집 수 M

        // 도시 정보 입력 및 집과 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[]{i, j}); // 집 좌표 저장
                } else if (value == 2) {
                    chickens.add(new int[]{i, j}); // 치킨집 좌표 저장
                }
            }
        }

        // 치킨집 중 M개를 선택하여 최소 치킨 거리 계산
        combination(new ArrayList<>(), 0);
        System.out.println(minChickenDistance); // 최소 치킨 거리 출력
    }

    // 치킨집 중 M개를 고르는 조합을 재귀적으로 계산
    public static void combination(List<int[]> selected, int start) {
        if (selected.size() == M) {  // M개의 치킨집을 선택한 경우
            minChickenDistance = Math.min(minChickenDistance, calculateChickenDistance(selected));
            return;
        }

        // 치킨집 선택
        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1); // 다음 치킨집 선택
            selected.remove(selected.size() - 1); // 선택 취소
        }
    }

    // 선택된 치킨집들로부터 각 집의 치킨 거리를 계산
    public static int calculateChickenDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        // 각 집에 대해 가장 가까운 치킨집 거리 계산
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]); // 맨해튼 거리 계산
                minDistance = Math.min(minDistance, distance); // 가장 가까운 치킨집과의 거리 선택
            }
            totalDistance += minDistance; // 총 치킨 거리에 더함
        }

        return totalDistance;
    }
}







