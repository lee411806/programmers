class Solution {
    public String solution(String rny_string) {
    
          String result = rny_string.chars()
	                .mapToObj(c -> (char) c)
	                .map(ch -> ch == 'm' ? "rn" : String.valueOf(ch))
	                .reduce("", (acc, str) -> acc + str);
        return result;
    }
}