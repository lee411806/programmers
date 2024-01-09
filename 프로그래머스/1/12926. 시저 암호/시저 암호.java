class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
            } else {
                int newChar = ch + n;

                if (Character.isUpperCase(ch) && newChar > 'Z') {
                    newChar = 'A' + (newChar - 'Z' - 1);
                } else if (Character.isLowerCase(ch) && newChar > 'z') {
                    newChar = 'a' + (newChar - 'z' - 1);
                }

                sb.append((char) newChar);
            }
        }

        return sb.toString();
    }
}