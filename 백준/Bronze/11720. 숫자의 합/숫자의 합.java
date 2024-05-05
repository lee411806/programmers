

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();
            String s2 = sc.nextLine();

            int sum = 0;
            for(int i=0; i < s2.length(); i++){
                sum += s2.charAt(i) - '0';
            }


        System.out.println(sum);




    }

}
