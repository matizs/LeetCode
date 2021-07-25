

public class Programmers_60057 {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length(); i++) {
            min = Math.min(getSize(s, i), min);
        }
        return min;
    }

    public int getSize(String s, int length) {
        int start = length;
        int size = 0;
        String prevString = s.substring(0, length);
        int count = 1;
        while (true) {
            int end = start + length >= s.length() ? s.length() : start + length;
            String sub = s.substring(start, end);

            if (prevString.equals(sub)) {
                count++;
            } else {
                size += prevString.length();
                prevString = sub;
                int c = (int) Math.log10(count) + 1;
                size += count > 1 ? c : 0;
                count = 1;
            }
            if (end >= s.length()) {
                break;
            }
            start = start + length;
        }
        size += prevString.length();
        if (count > 1) {
            size += (int) Math.log10(count) + 1;
        }
        return size;
    }
}
