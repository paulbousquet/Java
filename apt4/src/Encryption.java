import java.util.*;

public class Encryption {
    public String encrypt(String message){
        char[] see = message.toCharArray();
        HashMap<Character, Integer> nou = new HashMap<>();
        ArrayList cork = new ArrayList();
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int k = 0;
        for (char s:see){
            nou.putIfAbsent(s,k);
            if (!cork.contains(s)){
                cork.add(s);
                k+=1;
            }
        }
        StringBuilder coil = new StringBuilder("");
        for (char s:see){
            coil.append(alph[nou.get(s)]);
        }
        return coil.toString();
    }
}