import java.util.*;
public class SimpleWordGame {
    public int points(String[] player,
                      String[] dictionary) {
        int cute = 0;
        String[] dict = dictionary;
        List<String> plus = new ArrayList<String>(Arrays.asList(dict));
        List<String> minus = new ArrayList<String>();
        for (String oh:player){
            if (!minus.contains(oh)) {
                minus.add(oh);
            }
        }
        String[] sting = minus.toArray(new String[0]);
        for (String duh:sting){
            if (plus.contains(duh)){
                cute = cute + (duh.length())*(duh.length());
            }
        }
        return cute;
    }
}
