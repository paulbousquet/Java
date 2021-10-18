import java.util.*;
public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
        ArrayList list = new ArrayList();
        String[] hrases = new String[phrases.length];
        int count = 0;
        for (String str:phrases){
            str = str.replaceAll("\\s","");
            hrases[count] = str;
            count += 1;
        }
        for (String s:phrases){
            list.add(s);
        }
        for (int k=0;k< hrases.length;k++){
            TreeSet<Character> fun = new TreeSet<Character>();
            for (char a:hrases[k].toLowerCase().toCharArray()){
                fun.add(a);
            }
            for (int j=k+1;j< hrases.length;j++){
                TreeSet<Character> stoop = new TreeSet<Character>();
                for (char b:hrases[j].toLowerCase().toCharArray()){
                    stoop.add(b);
                }
                if (stoop.equals(fun)){
                    if (list.contains(phrases[j])){
                        list.remove(phrases[j]);
                    }
                }
            }
        }
        String[] meat = new String[list.size()];
        for (int k =0;k<meat.length;k++){
            meat[k] = list.get(k).toString();
        }
        return meat;
    }
}