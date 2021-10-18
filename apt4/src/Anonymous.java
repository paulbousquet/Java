public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        int fin = 0;
        for (String s:messages){
            int stor = 0;
            String[] goo = new String[1];
            goo[0] = s;
            String[] good = new String[headlines.length+1];
            for (int i=0;i< good.length;i++){
                if (i!= headlines.length) {
                    good[i] = headlines[i];
                }
                else {
                    good[i] = " ";
                }
            }
            for (char ch:s.toLowerCase().toCharArray()){
               if (getCounts(good)[ch] < getCounts(goo)[ch]){
                   stor = stor + 1;
               }
            }
            if (stor<1){
                fin = fin +1;
            }
        }
        return fin;
    }
    private int[] getCounts(String[] strings){
        int[] counts = new int[300];
        for (String s:strings){
            for (char ch:s.toLowerCase().toCharArray()){
                counts[ch] += 1;
            }
        }
        return counts;
    }
}
