import java.util.HashMap;
import java.util.Map;

public class YogiYo_1 {
    public static void main(String...msg){
        String s = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
        String c = "Example";
        System.out.println(Solution(s, c));
    }
    public static String Solution(String s, String c){
        String[] names = s.split(",");
        c = c.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < names.length; i++){
            String name = names[i].trim();
            String mailName = getMailName(name);
            sb.append(String.format("%s <%s@%s.com>, ", name, mailName, c));
        }
        return sb.toString();
    }
    static Map<String, Integer> duplicateNames = new HashMap<>();
    private static String getMailName(String fullName) {
        String name[] = fullName.split(" ");
        String firstName = name[0];
        String lastName = name[name.length-1];
        String mailName = firstName+"."+lastName;
        mailName = mailName.toLowerCase();
        mailName = mailName.replaceAll("-","");
        if(duplicateNames.containsKey(mailName)) {
            int count = duplicateNames.get(mailName) + 1;
            duplicateNames.put(mailName, count);
            mailName+=count;
        } else {
            duplicateNames.put(mailName, 1);
        }
        return mailName;
    }
}

