import java.util.*;
public class SetAside {
    public String common(String[] list) {
        TreeSet stor = new TreeSet(Arrays.asList(list[0].split(" ")));
        for (String a:list){
            TreeSet fun = new TreeSet(Arrays.asList(a.split(" ")));
            stor.retainAll(fun);
            }
        String cool = "";
        for (int k=0;k<stor.size();k++){
            if (k!=stor.size()-1){
                cool += stor.toArray()[k].toString() + " ";
            }
            else {
                cool += stor.toArray()[k].toString();
            }
        }
        return cool;
    }
}