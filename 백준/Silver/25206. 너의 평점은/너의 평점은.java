/*
문제
전공 평점을 계산해주는 프로그램

풀이
1. 입력 값 한번에 받으려면 참조값이 null 이 될때까지 받아야함
-> 입력값 복붙하고 엔터값 까지 먹어서 에러 => 입력값이 비어있으면이라는 조건도 추가
2.p를 제외한 모든 과목평점 switch로 만들어서 과목별 학점*과목평점, 학점의 총합을 구함
3. DecimalFormat으로 출력값 맞춤
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String subject;
        double majorSum =0;
        double scoreSum=0;

        while((subject = br.readLine()) != null && !subject.isEmpty()){ //복붙하고 엔터키 입력까지 먹어서 에러 -> !subject.isEmpty() 추가
            String[] subjects = subject.split(" ");

            if(!(subjects[2].equals("P"))){
                // 성적에 따라 점수를 계산하는 switch문
                double gradeScore = 0.0; //과목평점
                double credits = Double.parseDouble(subjects[1]);  // 학점

                switch (subjects[2]) {
                    case "A+":
                        gradeScore = 4.5;
                        break;
                    case "A0":
                        gradeScore = 4.0;
                        break;
                    case "B+":
                        gradeScore = 3.5;
                        break;
                    case "B0":
                        gradeScore = 3.0;
                        break;
                    case "C+":
                        gradeScore = 2.5;
                        break;
                    case "C0":
                        gradeScore = 2.0;
                        break;
                    case "D+":
                        gradeScore = 1.5;
                        break;
                    case "D0":
                        gradeScore = 1.0;
                        break;
                    case "F":
                        gradeScore = 0.0;  // F의 경우 평점이 0
                        break;
                    default:
                        continue;  // 유효하지 않은 성적이면 무시
                }

                // 학점 * 성적 점수로 계산
                majorSum += credits * gradeScore;
                scoreSum += credits;  // 전체 학점 합계
            }
        }

        double average = majorSum/scoreSum;
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(average));
    }

}



