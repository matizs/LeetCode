import java.util.ArrayList;
import java.util.List;

public class LeetCode_39 {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        splitNumber(target, 0, candidates, new ArrayList<>());
        return answer;
    }
    public void splitNumber(int current, int idx, int canditates[], List<Integer> result) {
        if(current == 0) {
            answer.add(new ArrayList<>(result));
            return;
        }
        for(int i = idx; i < canditates.length; i++){
            int calc = current - canditates[i];
            if(calc >= 0) {
                result.add(canditates[i]);
                splitNumber(calc, i, canditates, result);
                result.remove(result.size()-1);
            }
        }
    }
}
