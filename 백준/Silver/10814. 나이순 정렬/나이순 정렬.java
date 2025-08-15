

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//
        int T = Integer.parseInt(br.readLine());
        Member[] members = new Member[T];

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(age, name);
        }

        Arrays.sort(members,(a,b) -> a.age - b.age);


        for(Member member : members){

            System.out.println(member.age + " " + member.name);
        }


    }

    static class Member{
        int age;
        String name;

        public Member(int age, String name){
          this.age =age;
          this.name =name;
        }
    }

}
