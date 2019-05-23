package algorithm;

/**查找由空格分割开的最后一个字符串的长度.*/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (length == 0) continue;
                maxLength = length;
                length = 0;
            } else length++;
        }
        return length == 0 ? maxLength : length;
    }
}
