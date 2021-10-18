import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class MaxDonor {
    public String generous(String[] orgs, int[] amount) {
        HashMap<String, Integer> plug = new HashMap<>();
        for (int k=0;k< orgs.length;k++){
            plug.putIfAbsent(orgs[k],amount[k]);
            plug.put(orgs[k], plug.get(orgs[k])+amount[k]);
        }
        String oof = "";
        int winner = Collections.max(plug.values());
        for (int k=0;k<plug.size();k++){
            if (plug.get(plug.keySet().toArray()[k])==winner){
                oof = plug.keySet().toArray()[k].toString();
            }
        }
        oof += ":$";
        oof += winner;
        return oof;
    }
}