import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int week = Integer.parseInt(br.readLine());

        // 근무표 배열에 넣기
        String[][] workSchedule = new String[week * 4][7];

        // 근무 시간 계산 맵
        Map<String, Integer> workHoursMap = new HashMap<>();

        // 주
        for (int i = 0; i < week * 4; i++) {
            String[] temp = br.readLine().split(" ");

            // 일
            for (int j = 0; j < 7; j++) {
                workSchedule[i][j] = temp[j];

                // "-"는 근무자가 없음을 의미하므로 제외
                if (!workSchedule[i][j].equals("-")) {
                    // 일한 시간 맵에 근무 시간 넣기
                    if (!workHoursMap.containsKey(workSchedule[i][j])) {
                        workHoursMap.put(workSchedule[i][j], returnTime(i % 4));
                    } else {
                        int updateValue = workHoursMap.get(workSchedule[i][j]) + returnTime(i % 4);
                        workHoursMap.put(workSchedule[i][j], updateValue);
                    }
                }
            }
        }

        // 최소, 최대 값 뽑기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int rank : workHoursMap.values()) {
            if (rank < min) {
                min = rank;  // 최소값 갱신
            }
            if (rank > max) {
                max = rank;  // 최대값 갱신
            }
        }

        // 최소값과 최대값의 차이가 12시간 이하인지 확인
        String result = (max - min <= 12) ? "Yes" : "No";

        System.out.println(result);
    }

    // 근무 시간 계산 함수
    static public int returnTime(int week) {
        if (week == 0) {
            return 4;  // 08:00~12:00
        } else if (week == 1) {
            return 6;  // 12:00~18:00
        } else if (week == 2) {
            return 4;  // 18:00~22:00
        } else {
            return 10; // 22:00~08:00
        }
    }
}
