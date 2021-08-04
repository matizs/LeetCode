import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        List<Range> list = new ArrayList<>(intervals.length);
        Arrays.parallelSort(intervals, (a,b)->{
            if(a[0] == b[0])
                return 0;
            return a[0] <= b[0] ? -1 : 1;
        });
        System.out.println(intervals[0][0]);
        aa:for(int[] interval : intervals) {
            for(Range r : list) {
                if(r.start <= interval[0] && r.end >= interval[0]){
                    r.end = r.end > interval[1] ? r.end : interval[1];
                    continue aa;
                }
            }
            list.add(new Range(interval[0], interval[1]));
        }
        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < list.size(); i++){
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }
        return answer;
    }

    class Range {
        int start, end;
        public Range(int a, int b){
            this.start = a;
            this.end = b;
        }
    }
}
