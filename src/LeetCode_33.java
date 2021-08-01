import java.util.HashMap;
import java.util.Map;

public class LeetCode_33 {
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i], i);
        }

        if(map.containsKey(target)){
            return map.get(target);
        } else {
            return -1;
        }
    }
}
