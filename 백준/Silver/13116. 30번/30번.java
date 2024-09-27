import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
            /*
            입력
            테스트케이스, A,B값

            문제
            이진 트리에서 두 자연수 a,b에서 공통으로 포함된 노드 중 가장 큰 값

            풀이
            1. 이진트리 -> 배열 사용
            2. 최대 값 1023, 1023 배열 생성
            3. 공통 부모 노드를 찾는 단순 조건 -> DFS -> 재귀함수
            */

        //입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스의 수
        int testCaseCount = Integer.parseInt(br.readLine());

        //이진트리 생성(배열)

        int[] binaryTree = new int[1023];

        //이진트리 값 넣어 줌
        for (int i = 0; i <= 1022; i++) {
            binaryTree[i] = i + 1;
        }

        while (testCaseCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(findCommonParent(a,b) * 10);

            testCaseCount--;
        }
    }
    // 두 노드 a, b의 공통 부모를 찾고 가장 큰 값을 반환하는 함수
    public static int findCommonParent(int a, int b) {
        // 두 노드가 같으면 그 노드가 공통 부모
        if (a == b) {
            return a;
        }

        // a가 더 크다면 a의 부모로 올라감 -> 근 노드가 1이기 때문에 공식 조정
        if (a > b) {
            return findCommonParent(a / 2, b);
        }
        // b가 더 크다면 b의 부모로 올라감
        else {
            return findCommonParent(a, b / 2);
        }
    }


}
