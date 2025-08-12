
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int tShirt[] = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<6 ; i++){
                tShirt[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());

        int tCount = 0;
        // 티셔트 최소 묶음
        for(int i=0 ; i<tShirt.length; i++){
            if(tShirt[i]<=T && tShirt[i] != 0){
                tCount++;
            }else if(tShirt[i] > T){

                int temp = tShirt[i] / T;
                if(tShirt[i] % T != 0){
                    temp++;
                }

                tCount += temp;
            }
        }

        // 볼펜 최대 몇묵음 , 개인 주문
        int pen = N / P;
        int penPersonal = N % P;

        System.out.println(tCount);
        System.out.println(pen + " " + penPersonal);



    }
}
