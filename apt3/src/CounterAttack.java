import java.util.*;
public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        int[] ret = new int[words.length];
        String[] find = str.split(" ");
                for (int k=0;k< words.length;k++){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(find));
                    ret[k] = Collections.frequency(list,words[k]);
                }
        return ret;
    }
}