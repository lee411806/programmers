import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count =0;

    public static void main(String[] args) {

        //콘솔로 입력
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 첫 번째 입력: 몇 개의 문자열을 입력받을지
            int n = Integer.parseInt(br.readLine());

            // n개의 문자열을 입력받음
            String[] inputs = new String[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = br.readLine();
            }

            // count 출력
            for (String input : inputs) {
                System.out.println(isPalindrome(input) + " " + count);
                count=0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

}
