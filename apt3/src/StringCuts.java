import java.util.*;
public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> box = new ArrayList<>();
        for (String s:list){
            if (s.length()>=minLength && !box.contains(s)){
                box.add(s);
            }
        }
        String well[]=box.toArray(new String[box.size()]);
        return well;
    }
}
