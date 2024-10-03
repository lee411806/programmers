/*
문제
1.
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이

풀이
산술 평균 : 더해서 수 만큼 나눈다.
중앙 값 : 정렬 후 홀수면 인덱스 구하고 짝수면 가운데 두수 나누기
최빈 값 : 배열 인덱스 활용하여 풀 기
범위 : 정렬 사용
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 숫자 n개를 입력받아 처리하는 예시
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(average(n,numbers));
        System.out.println(middle(n,numbers));
        System.out.println(frequency(n,numbers));
        System.out.println(range(n,numbers));

    }

    public static int average(int n,int[] numbers) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }

        return Math.round((float)sum/n);
    }

    public static int middle(int n,int[] numbers) {
        Arrays.sort(numbers);
        if(n % 2 == 0) {
            int mid1 = numbers[n / 2 - 1];
            int mid2 = numbers[n / 2];
            return (mid1 + mid2) / 2;
        }else {
            return numbers[n/2];
        }
    }

    public static int frequency(int n,int[] numbers) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }

        // 최빈값을 저장할 리스트
        List<Integer> fList = new ArrayList<>();
        int maxFrequency = 0;

        // 최빈값 구하기
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                // 새로운 최빈값이 발견되면, 리스트를 초기화하고 새로 추가
                maxFrequency = frequency;
                fList.clear();
                fList.add(number);
            } else if (frequency == maxFrequency) {
                // 같은 빈도수일 경우 리스트에 추가
                fList.add(number);
            }
        }

        // 리스트를 정렬해서 두 번째로 작은 값을 찾음
        Collections.sort(fList);

        // 만약 최빈값이 하나뿐이라면 첫 번째 값을 반환, 여러 개라면 두 번째 값 반환
        if (fList.size() > 1) {
            return fList.get(1);  // 두 번째로 작은 값 반환
        } else {
            return fList.get(0);  // 최빈값이 하나일 경우 그 값 반환
        }
    }

    public static int range(int n, int[] numbers){

        Arrays.sort(numbers);

        int max = numbers[n-1];
        int min = numbers[0];

        return max -min;
    }
}




