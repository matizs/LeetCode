public class Programmers_12899 {
    public static void main(String...msg){
        System.out.println(solution(500000000));
    }
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int remain = 0;
        while(n > 0) {
            remain = n % 3;
            n /= 3;
            if(remain == 0){
                n-=1;
                remain = 4;
            }
            //answer = remain + answer;
            sb.insert(0, remain);
        }
        return sb.toString();
    }

    // 11 : 42
    // 12 : 44
    // 13 : 111
    // 14 : 112
    // 15 : 114

}
