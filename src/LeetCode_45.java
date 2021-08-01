import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_45 {
    boolean visited[];

    public int jump(int[] nums) {
        visited = new boolean[nums.length];
        return BFS(nums);
    }
    public int BFS(int[] nums){
        Queue<JumpPos> q = new LinkedList<>();
        q.add(new JumpPos(0, 0));
        while(!q.isEmpty()) {
            JumpPos jumpPos = q.poll();
            for(int i = 1 ; i <= nums[jumpPos.pos]; i++){
                int nextPos = jumpPos.pos + i;
                if(nextPos >= nums.length) continue;
                if(visited[nextPos]) continue;
                if(nextPos == nums.length-1) {
                    return jumpPos.count+1;
                }
                visited[nextPos] = true;
                q.add(new JumpPos(nextPos, jumpPos.count+1));
            }
        }
        return 0;
    }
    class JumpPos{
        int pos;
        int count = 0;

        public JumpPos(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }
}
