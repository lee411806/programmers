

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }


        Arrays.sort(arr);

        int count = 0;

        for(int i=0 ; i<N ; i++){
            int start = 0;
            int end = N-1;
            int target = arr[i];

            while(start<end){
                
                if(start == i){
                    start++;
                    continue;
                }
                
                if(end ==i){
                    end--;
                    continue;
                }
                
                int sum = arr[start] + arr[end];

                if(sum==target){
                    count++;
                    break;
                }else if(sum > target){
                    end--;
                }else{
                    start++;
                }

            }
        }

        System.out.println(count);
    }
}
