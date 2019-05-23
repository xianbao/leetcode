package algorithm;

import java.util.*;

/**
 * @author xiao
 * @date 2019/3/2
 * @descripion 对字符串进行分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>(50);
        List<Character> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (final String str : strs) {
            for (int index = 0; index < str.length(); index++) {
                list.add(str.charAt(index));
            }
            Collections.sort(list);
            for (char ch : list) {
                builder.append(ch);
            }
            String key = builder.toString();
            if (strMap.get(key) == null) {
                strMap.put(key, new ArrayList<String>(){{add(str);}});
            } else {
                strMap.get(key).add(str);
            }
            list.clear();
            builder.delete(0, builder.length());
        }
        for (Map.Entry<String, List<String>> entry : strMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = test.groupAnagrams(strs);




    }

}
