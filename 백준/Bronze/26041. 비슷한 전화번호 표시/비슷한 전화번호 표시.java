import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String tel[] = str.split(" ");

        String prefix = br.readLine();


        int count =0;

        for(int i=0;i<tel.length;i++){
            //.substring(0,2).equal 이런 문자열 하나라면 에러가 날 수 있음
            if(tel[i].startsWith(prefix) && !tel[i].equals(prefix)){
                count++;
            }
        }

        System.out.println(count);




    }
}