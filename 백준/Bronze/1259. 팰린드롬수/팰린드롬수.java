

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//      StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(br.readLine());

        String line;


        while(!(line = br.readLine()).equals("0")){

            int[] arr = new int[line.length()];
            char[] arrC = line.toCharArray();
            for(int i=0 ; i < arr.length ;i++){
                arr[i] = arrC[i] - '0';
            }

            Stack<Integer> stack = new Stack<>();
            String result = "yes";
            if(arr.length %2 == 0){
                for(int i=0 ;i<arr.length/2; i++){
                    stack.add(arr[i]);
                }
                for(int i=arr.length/2 ;i<arr.length; i++){
                    if(stack.pop() != arr[i]){
                        result = "no";
                        break;
                    }
                }
            }else if(arr.length%2 ==1){
                for(int i=0 ;i<arr.length/2; i++){
                    stack.add(arr[i]);
                }
                for(int i=arr.length/2+1 ;i<arr.length; i++){
                    if(stack.pop() != arr[i]){
                        result = "no";
                        break;
                    }
                }
            }
            System.out.println(result);
        }


    }
}
