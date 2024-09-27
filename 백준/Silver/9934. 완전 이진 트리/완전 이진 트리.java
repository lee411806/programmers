
/*
문제
중위 순회로 이루어진 입력값을 출력상으로 이진트리로 나타내어라
트리의 높이, 중위순휘된 배열 값

풀이
오른쪽 왼쪽 트리들 반복 -> 트리가 아래로 내려감 depth -> dfs -> 재귀함수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> levels;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int level = Integer.parseInt(br.readLine());

        int size = (int) Math.pow(2, level) - 1;

        int[] arr = new int[size];

        // 한 줄로 입력된 배열 값을 split하여 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 레벨별로 저장할 리스트 초기화
        levels = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            levels.add(new ArrayList<>());
        }

        dfs(arr,0,size -1,0);

        // 결과 출력
        for (List<Integer> currentLevel : levels) {
            for (int num : currentLevel) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }


    // 중위 순회 배열을 바탕으로 트리 출력 (재귀적 DFS)
    public static void dfs(int[] arr, int start, int end, int depth) {
        // 종료 조건: 더 이상 노드가 없으면 반환
        if (start > end) return;

        // 중간값(루트 노드)
        int mid = (start + end) / 2;

        // 해당 레벨(depth)에 중간값 추가
        levels.get(depth).add(arr[mid]);

        // 왼쪽 서브트리 탐색 (중간값 이전 구간)
        dfs(arr, start, mid - 1, depth + 1);

        // 오른쪽 서브트리 탐색 (중간값 이후 구간)
        dfs(arr, mid + 1, end, depth + 1);
    }

}
