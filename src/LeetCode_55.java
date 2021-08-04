import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_55 {
    boolean visited[];

    public boolean canJump(int[] nums) {
        visited = new boolean[nums.length];
        return BFS(nums);
    }
    public boolean BFS(int[] nums){
        Queue<JumpPos> q = new LinkedList<>();
        q.add(new JumpPos(0));
        while(!q.isEmpty()) {
            JumpPos jumpPos = q.poll();
            for(int i = 1 ; i <= nums[jumpPos.pos]; i++){
                int nextPos = jumpPos.pos + i;
                if(nextPos >= nums.length) continue;
                if(visited[nextPos]) continue;
                if(nextPos == nums.length-1) {
                    return true;
                }
                visited[nextPos] = true;
                q.add(new JumpPos(nextPos));
            }
        }
        return false;
    }
    class JumpPos{
        int pos;

        public JumpPos(int pos) {
            this.pos = pos;
        }
    }
}
