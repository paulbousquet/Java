import java.util.*;
public class HashListAutocomplete implements Autocompletor {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {

        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }

        if (terms.length != weights.length) {
            throw new IllegalArgumentException("terms and weights are not the same length");
        }
        initialize(terms,weights);
    }


    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (prefix == null) {
            throw new NullPointerException("One or more arguments null");
        }
        if (k < 0) {
            throw new IllegalArgumentException("terms and weights are not the same length");
        }
        if (prefix.length()>MAX_PREFIX){
            prefix = prefix.substring(0,MAX_PREFIX);
        }
        if (!myMap.containsKey(prefix)){
            List<Term> moif = new ArrayList<>();
            return moif;
        }
        List<Term> all = myMap.get(prefix);
        List<Term> list = all.subList(0, Math.min(k,all.size()));
        return list;
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        int i = 0;
        HashMap<String, List<Term>> monk = new HashMap<>();
        for (String s:terms){
            int plak = Math.min(MAX_PREFIX,s.length());
            for (int k=0;k<=plak;k++){
                String please = s.substring(0,k);;
                Term fork = new Term (terms[i], weights[i]);
                monk.putIfAbsent(please,new ArrayList<>());
                List<Term> ace = monk.get(please);
                ace.add(fork);
                monk.put(please,ace);
            }
            i += 1;
        }
        for (String s: monk.keySet()){
            Collections.sort(monk.get(s),Comparator.comparing(Term::getWeight).reversed());
        }
        myMap = monk;
    }

    @Override
    public int sizeInBytes() {
        if (mySize == 0) {
            for(String t : myMap.keySet()) {
                mySize += BYTES_PER_CHAR*t.length();
                List<Term> fj = myMap.get(t);
                for (Term lop:fj){
                    mySize += BYTES_PER_DOUBLE +
                            BYTES_PER_CHAR*(lop.getWord().length());
                }
            }
        }
        return mySize;
    }
}
