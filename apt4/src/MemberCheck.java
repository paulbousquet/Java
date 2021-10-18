import java.lang.reflect.Array;
import java.util.*;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        Set<String> result = new HashSet<>();
        Set<String> stor = new HashSet<>();
        Set<String> s1 = new HashSet<>(Arrays.asList(club1));
        Set<String> s2 = new HashSet<>(Arrays.asList(club2));
        Set<String> s3 = new HashSet<>(Arrays.asList(club3));
        result.addAll(s1);
        result.addAll(s2);
        result.retainAll(s3);
        stor.addAll(result);
        Set<String> resultt = new HashSet<>();
        resultt.addAll(s2);
        resultt.addAll(s3);
        resultt.retainAll(s1);
        stor.addAll(resultt);
        Set<String> resultd = new HashSet<>();
        resultd.addAll(s3);
        resultd.addAll(s1);
        resultd.retainAll(s2);
        stor.addAll(resultd);
        String[] ret = stor.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }
}