package algorithm;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    public boolean dfs(String s, int index, StringBuilder sb, List<String> wordDict) {
        if (wordDict.contains(sb.toString())) {
            sb.delete(0, sb.length());
            return true;
        }
        if (index > s.length()) return false;
        sb.append(s.charAt(index));

        return false;
    }


    public static void main(String[] args) {

    }
}
