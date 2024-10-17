
/*
문제
대칭 차집합
A-B , B-A 의 합집합을 대칭 차집합의 개수를 구하여라

입력 값
set.contains로 교집합 구해서 각 집합에서 빼주면 됨

풀이

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st1.nextToken()));
        }
//        System.out.println("A: " + A);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st2.nextToken()));
        }
//        System.out.println("B: " + B);

        Set<Integer> C = new HashSet<>(A);
        C.retainAll(B);

        A.removeAll(C);
        B.removeAll(C);


        System.out.println(A.size() + B.size());


    }
}



