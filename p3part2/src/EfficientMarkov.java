import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String, ArrayList<String>> myMap;

	public EfficientMarkov() {
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		int pos = 0;
		while (pos < myText.length()-myOrder+1){
			String foo = myText.substring(pos, pos + myOrder);
			if (pos + myOrder + 1 > myText.length()){
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
			String food = myText.substring(pos + myOrder, pos + myOrder + 1);
			if (!myMap.containsKey(foo)){
				ArrayList<String> stor = new ArrayList();
				stor.add(food);
				myMap.put(foo,stor);
			}
			else {
				myMap.get(foo).add(food);
			}
			pos += 1;
		}
	}



	@Override
	public ArrayList<String> getFollows(String key) {
		if (!myMap.containsKey(key)){
			throw new NoSuchElementException(key+" not in map");
		}
		return myMap.get(key);
	}
}
