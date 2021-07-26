import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_1835 {
    public static void main(String...msg){
        new Programmers_1835();
    }
    public Programmers_1835(){
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
    private char[] words = {'A','C','F','J','M','N','R','T'};
    private boolean visited[] = new boolean[256];
    private Map<Character, List<PicData>> picDataMap = new HashMap<>();
    private int result = 0;
    public int solution(int n, String[] data) {

        for(int i = 0 ; i < n; i++){
            char self = data[i].charAt(0);
            char target = data[i].charAt(2);
            PicData picData = new PicData(target, data[i].charAt(3), Character.getNumericValue(data[i].charAt(4)));
            List<PicData> list = picDataMap.get(self);
            if(list == null) {
                list = new ArrayList<>();
                picDataMap.put(self, list);
            }
            list.add(picData);

            PicData targetPicData = new PicData(self, data[i].charAt(3), Character.getNumericValue(data[i].charAt(4)));
            List<PicData> targetList = picDataMap.get(target);
            if(targetList == null) {
                targetList = new ArrayList<>();
                picDataMap.put(target, targetList);
            }
            targetList.add(targetPicData);
        }
        DFS(0, new ArrayList<>());
        return result;
    }
    private void DFS(int idx, List<Character> answer) {
        if(idx >= 8) {
            if(isSuccessCheckFilters(answer))
                result++;

            return;
        }
        for(int i = 0 ; i < 8; i++){
            char word = words[i];
            if(visited[word]) continue;
            visited[word] = true;
            answer.add(word);
            DFS(idx+1, answer);
            answer.remove(answer.size()-1);
            visited[word] = false;
        }
    }
    private boolean isSuccessCheckFilters(List<Character> targetList) {
        for (Character character : targetList) {
            List<PicData> picDataList = picDataMap.get(character);
            if(picDataList == null)
                continue;

            for (PicData picData : picDataList) {
                int wordIdx = targetList.indexOf(character);
                int targetIdx = targetList.indexOf(picData.target);
                if(!check(wordIdx, targetIdx, picData.Operand, picData.value)) {
                    return false;
                }
            }

        }
        return true;
    }
    private boolean check(int wordIdx, int targetIdx, char operand, int value) {
        int diff = Math.abs(targetIdx-wordIdx)-1;
        switch(operand) {
            case '<':
                return diff < value;
            case '>':
                return diff > value;
            case '=':
                return diff == value;
        }
        return false;
    }

    class PicData{
        char target;
        char Operand;
        int value;

        public PicData(char target, char operand, int value) {
            this.target = target;
            Operand = operand;
            this.value = value;
        }

        @Override
        public String toString() {
            return "PicData{" +
                    "target=" + target +
                    ", Operand=" + Operand +
                    ", value=" + value +
                    '}';
        }
    }
}
