import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_1829 {
    private int size = 0;
    private boolean visited[][];
    private int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String...msg){
        new Programmers_1829();
    }
    public Programmers_1829(){
        System.out.println(solution(6,4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
    }
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if(picture[i][j] == 0 )continue;
                numberOfArea++;
                size = 0;
                BFS(i,j, picture, m, n, picture[i][j]);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void BFS(int y, int x, int picture[][], int m, int n, int value) {
        Point start = new Point(x, y);
        Queue<Point> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Point pos = q.poll();
            size++;
            for(int i = 0 ; i < 4; i++){
                int ny = pos.y + dir[i][0];
                int nx = pos.x + dir[i][1];

                if(ny < 0 || nx < 0 || ny>= m || nx>=n) continue;
                if(visited[ny][nx]) continue;
                if(picture[ny][nx] != value) continue;
                visited[ny][nx] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

}
