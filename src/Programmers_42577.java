import java.util.HashSet;
import java.util.Set;

public class Programmers_42577 {
    public static void main(String...msg){
        System.out.println(solution(new String[]{"123","456","789"}));
    }
    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String book : phone_book) {
            set.add(book);
        }
        for(String book : phone_book) {
            for(int i = 1 ; i < book.length(); i++){
                String sub = book.substring(0, i);
                if(set.contains(sub))
                    return false;
            }
        }
        return true;
    }
}
