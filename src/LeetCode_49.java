import java.util.*;

public class LeetCode_49 {
    private Map<Integer, List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(String str : strs) {
            List<String> group = findGroupByString(str);
            if(group.isEmpty())
                result.add(group);
            group.add(str);
        }
        return result;
    }
    private List<String> findGroupByString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int hash = generateHash(chars);
        if(map.containsKey(hash)) {
            return map.get(hash);
        } else {
            List<String> arrayList = new ArrayList<>();
            map.put(hash, arrayList);
            return arrayList;
        }
    }
    private int generateHash(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString().hashCode();
    }
}
