import java.util.*;
public class SandwichBar {
    public int whichOrder(String[] available, String[] orders) {
        int cute = -1;
        List<String> plus = new ArrayList<String>();
        for (String word : available) {
            plus.add(word);
        }
        List<String> minus = new ArrayList<String>();
        for (String words : orders) {
            if (!minus.contains(words)) {
                minus.add(words);
            }
        }
        String[] sting = minus.toArray(new String[0]);
        String[] ray = plus.toArray(new String[0]);
        List<String> cort = new ArrayList<String>();
        for (int i = 0; i < plus.size(); i++) {
            String s = "";
            for (int j = i; j < plus.size(); j++)  {
                s += plus.get(j);
                cort.add(s);
                s += " ";
                String flex = s;
                flex += plus.get(j);
                cort.add(flex);
            }
        }
        for (int i = 0; i < plus.size(); i++) {
            String s = "";
            for (int j = i; j < plus.size(); j++)  {
                s += plus.get(plus.size()-j-1);
                String flex = plus.get(j);
                flex += " ";
                flex += s;
                cort.add(flex);
                cort.add(s);
                s += " ";
            }
        }
        String[] band = cort.toArray(new String[0]);
        for (int k=0; k < sting.length; k++) {
            if (cort.contains(minus.get(k))){
                cute = k;
                break;
            }
        };
        return cute;
    }
}