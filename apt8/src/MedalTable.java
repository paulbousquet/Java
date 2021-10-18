import java.util.*;

public class MedalTable {
    private class MedalCountry {
        String myName;
        int gold;
        int silver;
        int bronze;

        MedalCountry(String name) {
            myName = name;
        }

        public String getName() {
            return myName;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }
        @Override
        public String toString(){
            return myName + " " + Integer.toString(gold) + " " +Integer.toString(silver) + " "+ Integer.toString(bronze);
        }
    }
    public String[] generate(String[] results){
        TreeMap<String, MedalCountry> map = new TreeMap<>();
        for (int i=0;i< results.length;i++){
            String[] winners = results[i].split(" ");
            for (int j=0;j<3;j++){
                MedalCountry c = map.get(winners[j]);
                if (c==null){
                    c = new MedalCountry(winners[j]);
                    map.putIfAbsent(c.myName,c);
                }
                if (j==0) c.gold++;
                if (j==1) c.silver++;
                if (j==2) c.bronze++;
            }
        }
        ArrayList<MedalCountry> helper = new ArrayList<>(map.values());
        Collections.sort(helper, Comparator.comparing(MedalCountry::getGold).thenComparing(MedalCountry::getSilver).thenComparing(MedalCountry::getBronze).reversed());
        String[] answer = new String[helper.size()];
        for (int i=0;i< answer.length;i++) answer[i]=helper.get(i).toString();
        return answer;
    }
}