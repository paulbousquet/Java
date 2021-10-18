import java.util.*;

public class WeightSort {
    public String[] sort(String[] strs) {
        char[] al = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Character,Integer> plain = new HashMap<Character, Integer>();
        int plop = 1;
        for (char a:al){
            plain.put(a,plop);
            plop += 1;
        }
        HashMap<String, Integer> fin = new HashMap<>();
        for (String k:strs){
            char[] ping = k.toLowerCase().toCharArray();
            for (char m:ping){
                fin.putIfAbsent(k,0);
                int lop = fin.get(k)+plain.get(m);
                fin.put(k,lop);
            }
        }
        Object[] a = fin.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                if(((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue())!=0){
                    return ((Map.Entry<String, Integer>) o2).getValue()
                            .compareTo(((Map.Entry<String, Integer>) o1).getValue());
                }
                else{
                    String intObj = ((((Map.Entry<String, Integer>) o2).getKey()));
                    String intObjj = (((Map.Entry<String, Integer>) o1).getKey());
                    return(intObj).compareTo(intObjj);
                }

            }
        });
        String[] look = new String[strs.length];
        int fool = 0;
        for (Object e : a) {
            look[fool] = ((Map.Entry<String, Integer>) e).getKey().toString();
            fool += 1;
        }
        List<String> list = Arrays.asList(look);
        Collections.reverse(list);
        return list.toArray(look);
    }
}