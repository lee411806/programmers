
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> solution(String my_string) {
        List<String> li = new ArrayList<>();
         String my_string2 ="";
        for (int i = my_string.length() - 1; i >= 0; i--) {
            my_string2 = String.valueOf(my_string.charAt(i)) + my_string2;
            li.add(my_string2);
        }
        
        Collections.sort(li);
        
        return li;
    }
}