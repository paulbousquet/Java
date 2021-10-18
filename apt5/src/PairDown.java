import java.util.ArrayList;

public class PairDown {
    public int[] fold(int[] list) {
        ArrayList<Integer> oop = new ArrayList();
        int[] test = new int[list.length];
        if (list.length % 2 != 0){
            test = new int[list.length+1];
            for (int i = 0;i<list.length;i++){
                test[i] = list[i];
            }
            test[test.length-1] = 0;
        }
        else {
            for (int i = 0;i<list.length;i++){
                test[i] = list[i];
            }
        }
        for (int k=0;k<test.length;k+=2){
            oop.add(test[k]+test[k+1]);
        }
        int[] prin = new int[list.length/2+list.length % 2];
        for (int i=0;i<prin.length;i++){
            prin[i] = oop.get(i);
        }
        return prin;
    }
}