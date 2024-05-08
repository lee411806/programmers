import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            // int형으로 못받아서 String 으로 받으려 했으나 어차피 int배열로 받는거면 크기 상관 없다.

            long sum =0;
            long max = 0;

            for(int i = 0; i < num; i++){
                int temp = sc.nextInt();
                if(temp>max)max=temp;
                sum=sum+temp;
            }

        System.out.println(sum*100.0/max/num);

    }
}
