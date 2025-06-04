/*
문제 : 연속 수 제거
풀이 : 1. stack에 연속 수 비교하면서 담는다.
*/



import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() != num )
                stack.push(num);
        }
        
        return stack;
    }
}