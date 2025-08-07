
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1= br.readLine().toCharArray();
        char[] arr2= br.readLine().toCharArray();

        int[] countA = new int[26]; // 'a'~'z'에 해당
        int[] countB = new int[26];

        for(int i=0 ; i<arr1.length;i++){
            countA[arr1[i] - 'a']++;
        }

        for(int i=0 ; i<arr2.length;i++){
            countB[arr2[i] - 'a']++;
        }

        int result =0;
        for(int i=0; i< 26; i++){
            result += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(result);



    }
}