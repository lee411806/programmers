/*
문제
+,-, 숫자로 이루어진 식에서 최소 값을 구하여라

입력 값
계산 식

풀이
1. 1번 예시를 보아 -기준으로 앞에걸 먼저 계산 후 뒤에 계산 -> - 기준으로 split
2. 0으로 시작할 수 있다 Integer로 parse하면 자동으로 0 사라짐
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("\\-");

        int result = calculate(str[0]);

//        for(int i = 1; i < str.length; i++){
//            System.out.print(str[i]+" ");
//        }

        for(int i = 1; i < str.length; i++){
            String temp= str[i];
            result -= calculate(temp);
        }

        System.out.println(result);

    }

    public static int calculate(String temp){

        if(temp.contains("+")){
            //regex에 +들어가면 +가 아니라 앞에 문자가 하나 이상의 의미로 받아들여져서 이스케이프 문자로 문자그대로 사용해 줄 수 있게 해야함
           String[] temp2 = temp.split("\\+");
           int sum =0;

           for(int i = 0; i < temp2.length; i++){
               sum += Integer.parseInt(temp2[i]);
           }
           return sum;

        }else{
            return Integer.parseInt(temp);
        }

    }

}



