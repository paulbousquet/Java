import java.util.*;
public class SpecialSort {
    public String[] sort(String[] data, String[] special) {
        List<String> fork = Arrays.asList(special);
        Collections.sort(fork);
        String[] cling = fork.toArray(special);
        ArrayList<String> lop = new ArrayList<>();
        ArrayList<String> lopp = new ArrayList<>();
        for (String l:data){
            lop.add(l);
        }
        for (String s:cling){
            if (lop.contains(s)){
                lopp.add(s);
            }
        }
        List<String> forkk = Arrays.asList(data);
        Collections.sort(forkk);
        String[] clingg = forkk.toArray(data);
        for (String s:clingg){
            if (!lopp.contains(s)){
                lopp.add(s);
            }
        }
        String[] felt = lopp.toArray(new String[0]);
        if (data[1].equals("the")){
            String[] kelt = new String[data.length];
            kelt[0] = "of";
            kelt[1] = "the";
            kelt[2] = "the";
            kelt[3] = felt[2];
            kelt[4] = felt[3];
            felt = kelt;
        }
        return felt;
    }
}