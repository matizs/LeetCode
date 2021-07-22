public class LeetCode_11 {
    public static void main(String...msg){
        int[] a = new int[]{4,3,2,1,4};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        int max = Math.min(height[0], height[height.length-1]) * (height.length-1);
        int i = 0;
        int j = height.length - 1;
        while(i < j ) {
            int minHeight = Math.min(height[i], height[j]);
            max = Math.max(max, minHeight * (j-i));
            if(height[i] < height[j]) {
                int prevI = i;
                while(i < height.length) {
                    if(height[i] > height[prevI]){
                        break;
                    }
                    i++;
                }
            } else {
                int prevJ = j;
                while(j >= 0) {
                    if(height[j] > height[prevJ]){
                        break;
                    }
                    j--;
                }
            }
        }
        return max;
    }
}
