import java.util.*;
class Solution {
    public List<String> solution(String myString) {
        String[] answer = myString.split("x",0);
        
        Arrays.sort(answer);
        
         ArrayList<String> resultList = new ArrayList<>();

                for (String str : answer) {
                    if (!str.isEmpty()) {
                        resultList.add(str);
                    }
                }
        
        return resultList;
    }
}