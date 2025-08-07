
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] document = br.readLine().toCharArray();
        char[] search = br.readLine().toCharArray();

        int count =0;

        for(int i=0 ; i<= document.length - search.length; i++){
            int k = i;

            for(int j=0 ; j< search.length; j++){

                if(document[k] == search[j]){
                    k++;
                } else{
                    break;
                }
                if(j == search.length-1){
                    count++;
                    i += search.length-1;
                }
            }

        }

        System.out.println(count);


    }
}
