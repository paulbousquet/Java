public class SimpleWordGramDriver {
    public static void main(String[] args) {
        String[] words = {"aa", "bb", "cc"};
        WordGram g = new WordGram(words,0,3);
        System.out.printf("gram = %s, length = %d, hash = %d\n",
                          g,g.length(),g.hashCode());

        String[] wurds = {"aa", "bb", "cc"};
        WordGram ng = new WordGram(words,0,3);
        System.out.printf("gram = %s, length = %d, hash = %d\n",
                ng,ng.length(),ng.hashCode());
        System.out.print(ng.equals(g));
    }
}
