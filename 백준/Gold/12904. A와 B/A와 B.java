/*
문제
1. 두 문자열이 주어짐
2. 문자열 뒤에 A 추가, 문자열을 뒤집고 뒤에 B를 추가
3. 2번의 조건으로 두 문자열이 같아질 수 있는지 확인하는 문제

풀이
1. s->t , t->s
2. 조건 반대로 생각해서 푼다.
3. 맨 뒤에 문자가 A면 A를 뺀다, 맨 뒤 문자가 B면 문자열을 뒤집고 맨앞의 B를 뺀다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

//        String t = "ABBA";
//        System.out.println(t.substring(0, t.length()-1));
        while(s.length() != t.length()){

            if(t.charAt(t.length()-1) == 'A'){
                t = t.substring(0, t.length()-1);
            } else if (t.charAt(t.length()-1) == 'B') {
                char[] arr = t.toCharArray();
                int start =0;
                int end =arr.length-1;
                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;

                    start++;
                    end--;
                }
                t = new String(arr);
                t = t.substring(1, t.length());
            }


        }

        if(s.equals(t)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }
}



