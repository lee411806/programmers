/*
문제
(로 열렸으면 )로 짝지어져서 끝나야한다.

풀이
Stack 으로 (면 stack에 넣고 )면 (을 스택에서 빼준다.
마지막에 stack이 비어있으면 올바른 괄호
*/

import java.util.*;

class Solution {
    boolean solution(String s) {
     
        Stack<Character> stack = new Stack<>();
        
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                return false;    
                }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
}