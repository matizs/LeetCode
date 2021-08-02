public class Programmers_weekly_1 {

    public long solution(long price, long money, long count) {
        return Math.max(price * (count*(count+1)/2) - money, 0);
    }
}
