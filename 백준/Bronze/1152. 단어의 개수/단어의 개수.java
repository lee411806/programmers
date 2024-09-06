import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if(str.equals(" ")){
            System.out.println("0");
        }else {
            str = str.trim();
            String words[] = str.split(" ");

//        for(String word : words){
//            System.out.println(word);
//        }



            System.out.println(words.length);

        }




    }
}