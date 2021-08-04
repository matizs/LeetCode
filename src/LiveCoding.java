import java.util.Scanner;
import java.util.Stack;

public class LiveCoding {
    public static void main(String...msg){
        new LiveCoding();
    }
    public LiveCoding() {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println(getAnswer(data));
    }

    private int getAnswer(String data) {
        Stack<Character> stack = new Stack();

        for(int i = 0 ; i < data.length(); i++){
            char currentWord = data.charAt(i);

            if(stack.isEmpty() || stack.peek() != currentWord) {
                stack.add(currentWord);
            } else {
                stack.pop();
            }
        }
        System.out.println(stack);
        return stack.isEmpty() ? 1 : 0;
    }
}