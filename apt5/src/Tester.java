import java.util.*;

public class Tester {
    public static void main(String args[]) {
        String[] welp = {"Aaagmnrs", "TopCoder", "anagrams", "Drop Cote"};
        Aaagmnrs ohh = new Aaagmnrs();
        String[] food = ohh.anagrams(welp);
        System.out.println(Arrays.toString(food));
    }
}
