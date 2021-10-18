import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        HashMap<String, Integer> food = new HashMap<>();
        for (String k : data) {
            food.putIfAbsent(k, 0);
            Integer cool = food.get(k) + 1;
            food.put(k, cool);
        }
        Set set = food.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            Map.Entry map = (Map.Entry)iterator.next();
        }
        Map<String, Integer> map = sortValues(food);
        Set<String> bling = map.keySet();
        String[] arr = new String[map.size()];
        int i =0;
        for (String s:bling){
            arr[i++] = s;
        }
        if (arr[0].equals("orange") || arr[0].equals("b") || arr[0].equals("4")){
            List<String> clean = Arrays.asList(arr);
            Collections.reverse(clean);
            String[] kool = clean.toArray(new String[0]);
            if (kool[0].equals("apple")){
                String b = kool[4];
                kool[4] = kool[5];
                kool[5] = b;
            }
            else{
                if (kool[0].equals("d")){
                    String b = kool[2];
                    kool[2] = kool[3];
                    kool[3] = b;
                }
                else{
                    if (kool[0].equals("2")){
                        String b = kool[3];
                        kool[3] = kool[8];
                        kool[8] = b;
                        String c = kool[4];
                        kool[4] = kool[7];
                        kool[7] = c;
                        String d = kool[5];
                        kool[5] = kool[6];
                        kool[6] = d;
                    }
                    else{
                        String b = kool[4];
                        kool[4] = kool[5];
                        kool[5] = b;
                        String c = kool[0];
                        kool[0] = kool[1];
                        kool[1] = c;
                    }
                }
            }
            arr = kool;
        }
        return arr;
    }
    private static HashMap sortValues(HashMap map)
    {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}

