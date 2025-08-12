
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int T = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int[] intArr = new int[26];

        for(int i=0; i<intArr.length;i++){
            intArr[i] = -1;
        }

        for(int i=0; i<arr.length;i++){

            int index = arr[i] - 'a';
            if(intArr[index] == -1){
                intArr[index] = i;
            }else{

            }

        }

        for(int temp : intArr){
            System.out.print(temp+" ");
        }

    }
}
