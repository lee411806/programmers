import java.util.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[i].length(); j++){
                for(int x=0; x<k; x++){
                    sb.append(picture[i].charAt(j));
                }
            }
            for(int j=0; j<k; j++){
                list.add(sb.toString());
            }
            sb.delete(0, sb.length());
        }
        
        return list.toArray(new String[list.size()]);
    }
}