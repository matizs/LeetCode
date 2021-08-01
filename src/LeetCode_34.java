import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_34 {
    public int[] searchRange(int[] nums, int target) {
        Map<Integer, List> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }
        List<Integer> list = map.get(target);
        if (list == null)
            return new int[]{-1, -1};

        int answer[] = new int[2];
        if (list.size() == 1) {
            answer[0] = list.get(0);
            answer[1] = list.get(0);
        } else {
            answer[0] = list.get(0);
            answer[1] = list.get(list.size()-1);
        }

        return answer;
    }
}
