public class LeetCode_152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
           if(nums[i] > 0) {
               max = Math.max(nums[i], max * nums[i]);
               min = Math.min(nums[i], min * nums[i]);
           } else {
               int m = min;
               min = Math.min(nums[i], max * nums[i]);
               max = Math.max(nums[i], m * nums[i]);
           }
           result = Math.max(max, result);
        }
        return result;
    }
//    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for(int i = 0 ; i < nums.length -1 ; i++){
//            int value = nums[i];
//            for(int j = i+1; j < nums.length; j++){
//                value *= nums[j];
//                max = Math.max(max, value);
//            }
//
//        }
//        return max;
//    }
}
