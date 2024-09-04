import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //입력 값 받아오는 scanner 가져옴
        Scanner sc = new Scanner(System.in);

        Long a = sc.nextLong();
        Long b = sc.nextLong();

        if(a>b){
            System.out.println(">");
        }else if(a<b){
            System.out.println("<");
        }else{
            System.out.println("==");
        }

    }
}