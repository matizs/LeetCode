import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static int N,L,answer;
    public static boolean isPunk[] = new boolean[1001];
    public static void main(String...msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        String p[] = br.readLine().split(" ");
        int pos[] = new int[N];


        for(int i = 0 ; i < N; i++){
            int value = Integer.parseInt(p[i]);
            isPunk[value] = false;
            pos[i] = value;
        }
        Arrays.sort(pos);
        execute(isPunk, pos);
        System.out.println(answer);
    }
    private static void execute(boolean isPunk[], int pos[]){
        for(int i = 0 ; i < pos.length; i++){
            int startPos = pos[i];
            System.out.println(startPos);
            if(isPunk[startPos])
                continue;
            for(int j = startPos ; j < startPos+L ; j++){
                if(j >= isPunk.length) break;
                isPunk[j] = true;
            }
            answer++;
        }

    }
}
