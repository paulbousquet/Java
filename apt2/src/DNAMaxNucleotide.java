public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        int stor = 0;
        String dum = "";
        for (String st : strands) {
            int comp = 0;
            int jav = st.length();
            int jan = dum.length();
            for (String k : st.split("")){
                if (k.contains(nuc)){
                    comp = comp +1;
                }
            }
            if (comp>stor){
                dum = st;
                stor = comp;
            }
            if (comp==stor && jav>jan && comp!=0){
                dum = st;
            }
        }
        return dum;
    }
}
