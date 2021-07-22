import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17 {
    List<String> answer = new ArrayList<>();
    Map<Character, char[]> digitMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return answer;
        digitMap.put('2',new char[]{'a','b','c'});
        digitMap.put('3',new char[]{'d','e','f'});
        digitMap.put('4',new char[]{'g','h','i'});
        digitMap.put('5',new char[]{'j','k','l'});
        digitMap.put('6',new char[]{'m','n','o'});
        digitMap.put('7',new char[]{'p','q','r','s'});
        digitMap.put('8',new char[]{'t','u','v'});
        digitMap.put('9',new char[]{'w','x','y','z'});
        DFS(digits, 0, "");
        return answer;
    }
    private void DFS(String digits, int idx, String result){
        if(idx >= digits.length()){
            answer.add(result);
            return;
        }
        char[] chars = digitMap.get(digits.charAt(idx));
        for(int i = 0 ; i <chars.length; i++){
            DFS(digits, idx+1, result+chars[i]);
        }
    }
}
