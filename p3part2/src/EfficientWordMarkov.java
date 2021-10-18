import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(3);
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        myMap.clear();
        myWords = text.split("\\s+");
        int finish = myWords.length-myOrder+1;
        int count = 0;
        for (int k=0;k<myWords.length-myOrder+1;k++){
            count += 1;
            if (count==finish){
                WordGram foo = new WordGram(myWords,k,myOrder);
                if (!myMap.containsKey(foo)){
                    ArrayList<String> stor = new ArrayList();
                    stor.add(PSEUDO_EOS);
                    myMap.put(foo,stor);
                }
                else {
                    myMap.get(foo).add(PSEUDO_EOS);
                }
                break;
            }
            else{
                WordGram foo = new WordGram(myWords,k,myOrder);
                if (!myMap.containsKey(foo)) {
                    ArrayList<String> stor = new ArrayList();
                    stor.add(myWords[k+myOrder]);
                    myMap.put(foo,stor);
                }
                else {
                    myMap.get(foo).add(myWords[k+myOrder]);
                }
            }
        }
    }

    @Override
    public ArrayList<String> getFollows(WordGram key) {
        if (!myMap.containsKey(key)) {
            throw new NoSuchElementException(key.toString() + " not in map");
        } else {
            return myMap.get(key);
        }
    }
}