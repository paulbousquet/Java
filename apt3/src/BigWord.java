import java.util.*;
public class BigWord {
    public String most(String[] sentences) {
        String sent = Arrays.toString(sentences);
        String tent = sent.toLowerCase();
        String[] kind = tent.split(",");
        String lint = Arrays.toString(kind);
        String[] find = lint.split(" ");
        ArrayList<String> box = new ArrayList<>();
        int[] goul = new int[find.length];
        int comf = 0;
        for (int k=0;k<goul.length;k++){
            if (box.contains(find[k])){
                goul[k-comf-1] = goul[k-comf-1]+1;
                comf = comf+1;
            }
            else{
                box.add(find[k]);
            }
        }
        int max = goul[0];
        int index = 0;

        for (int i = 0; i < goul.length; i++) {
            if (max < goul[i])
            {
                max = goul[i];
                index = i;
            }
        }
        String prin = "";
        int sight = 0;
        for (String s:find){
            if (sight==index){
                prin = s;
            }
            sight = sight + 1;
        }
        return prin;
    }
}