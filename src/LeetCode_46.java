import java.util.ArrayList;
import java.util.List;

public class LeetCode_46 {
    private boolean visited[];
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        Permutation(nums, 0, new ArrayList<>());
        return answer;
    }
    private void Permutation(int[] nums, int idx, List<Integer> result){
        if(idx == nums.length) {
            answer.add(new ArrayList<>(result));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            result.add(nums[i]);
            Permutation(nums, idx+1);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}
