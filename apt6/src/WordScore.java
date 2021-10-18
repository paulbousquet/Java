import java.lang.reflect.Array;
import java.util.*;
public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        char[] add = want.toCharArray();
        char[] ded = avoid.toCharArray();
        ArrayList link = new ArrayList();
        ArrayList mop = new ArrayList();
        for (char j:add){
            if (!link.contains(j)){
                link.add(j);
            }
        }
        for (char j:ded){
            if (!mop.contains(j)){
                mop.add(j);
            }
        }
        char[] rev = link.toString().toCharArray();
        char[] met = mop.toString().toCharArray();
        int loo = 0;
        int[] task = new int[words.length];
        for (String i:words){
            int score = 0;
            for (char j:i.toCharArray()){
                for (char k:rev){
                    if (k==j){
                        score += 1;
                    }
                }
                for (char k:met){
                    if (k==j){
                        score += -1;
                    }
                }
            }
            task[loo] = score;
            loo+=1;
        }
        return task;
    }
}