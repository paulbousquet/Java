import java.util.Arrays;
import java.util.TreeSet;

public class Closet {
    public String anywhere(String[] list) {
        TreeSet stor = new TreeSet(Arrays.asList(list[0].split(" ")));
        for (String a:list){
            TreeSet fun = new TreeSet(Arrays.asList(a.split(" ")));
            stor.addAll(fun);
        }
        String cool = "";
        for (int i=0;i<stor.size();i++){
            if (i!=stor.size()-1){
                cool += stor.toArray()[i].toString() + " ";
            }
            else {
                cool += stor.toArray()[i].toString();
            }
        }
        return cool;
    }
}