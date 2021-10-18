import java.util.*;

public class LengthSort {
    public String[] rearrange(String[] values){
        HashMap<Integer,ArrayList> food = new HashMap<>();
        for (String k:values){
            ArrayList ele = new ArrayList();
            ele.add(k);
            food.putIfAbsent(k.length(), ele);
            ArrayList proc = food.get(k.length());
            if (!proc.contains(k)){
                proc.add(k);}
            food.put(k.length(),proc);
        }
        ArrayList sizes = new ArrayList();
        for (String q:values){
            if (!sizes.contains(q.length())){
                sizes.add(q.length());
            }
        }
        Collections.sort(sizes);
        int[] ret = new int[sizes.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = Integer.parseInt(sizes.get(i).toString());
        }
        ArrayList poof = new ArrayList();
        for (Integer i:ret){
            ArrayList nuan = food.get(i);
            Collections.sort(nuan);
            poof.addAll(nuan);
        }

        String[] fair = new String[poof.size()];
        for (int i=0; i < fair.length; i++)
        {
            fair[i] = poof.get(i).toString();
        }
        return fair;
    }
}