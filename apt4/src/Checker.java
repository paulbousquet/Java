import java.util.*;
public class Checker {
    public String maxKey(HashMap<String,ArrayList<String>> map) {
        int store = 0;
        StringBuilder juice = new StringBuilder("hell");
        StringBuilder test = new StringBuilder("hell");
        for (String s:map.keySet()){
            int comp = map.get('s').l;
            if (comp > store) {
                store = comp;
                juice.replace(0,juice.length(),String s)
            }
            test.replace(0,juice.length(),String s);
        }
        if (store==0) {
            String tester = test.tostring;
            juice.replace(0,juice.length(),String tester);
        }
        String fruit = juice.tostring;
        return fruit;
    }

}

