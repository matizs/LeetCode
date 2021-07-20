import java.util.*;
public class LeetCode_3_Longest_SubString_Without_repeating_Characters {
    public  int lengthOfLongestSubstring(String s) {
        int len = 0;

        int maxLen = 0;
        int idx = 0;
        Set<Character> containCharacters = new HashSet<>();
        for(int i = 0 ; i < s.length(); i++){
            char nowChar = s.charAt(i);
            if(containCharacters.contains(nowChar)) {
                maxLen = Math.max(maxLen, len);
                len = 0;
                i = getIndexOf(s, nowChar, idx);
                idx = getIndexOf(s, nowChar, idx)+1;
                containCharacters.clear();
                continue;
            } else {
                len++;
            }
            containCharacters.add(nowChar);
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
    public int getIndexOf(String s, char c, int start) {
        for(int i = start ; i < s.length(); i++){
            if(s.charAt(i)==c)
                return i;
        }
        return 0;

    }
}
