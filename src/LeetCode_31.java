import java.util.Arrays;

public class LeetCode_31 {
    public void nextPermutation(int[] nums) {
        int left = 0, right = nums.length - 1;
        boolean isPlus = false;
        while (true) {
            checkResult result = hasCheck(nums, left, right);
            if (!result.isSuccess) {
                if (isPlus) {
                    left -= 1;
                    right += 1;
                }
                break;
            }
            isPlus = true;
            left = result.left + 1;
            right = result.right - 1;
        }
        swap(nums, left, right);
        subArraySort(nums, left + 1);
        if(!isPlus)
        Arrays.sort(nums);
    }

    private checkResult hasCheck(int[] nums, int left, int right) {
        for (int i = right; i >= 1; i--) {
            for (int j = i - 1; j >= left; j--) {
                if (nums[i] > nums[j]) {
                    return new checkResult(j, i, true);
                }
            }
        }
        return new checkResult(0, 0, false);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void subArraySort(int[] nums, int startIdx) {
        if (startIdx >= nums.length)
            return;

        int size = nums.length - startIdx;
        int[] newArray = new int[size];
        int idx = startIdx;
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = nums[idx++];
        }
        Arrays.sort(newArray);
        idx = 0;
        for (int i = startIdx; i < nums.length; i++) {
            nums[i] = newArray[idx++];
        }
    }

    class checkResult {
        int left, right;
        boolean isSuccess = false;

        public checkResult(int a, int b, boolean c) {
            left = a;
            right = b;
            isSuccess = c;
        }
    }
}
