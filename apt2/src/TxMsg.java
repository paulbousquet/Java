import java.util.*;
public class TxMsg {
    public String getMessage(String original) {
        List<Character> al = new ArrayList<Character>();
        al.add('a');
        al.add('e');
        al.add('i');
        al.add('o');
        al.add('u');
        al.add('A');
        al.add('E');
        al.add('I');
        al.add('O');
        al.add('U');
        List<Character> alf = new ArrayList<Character>();
        alf.add('b');
        alf.add('c');
        alf.add('d');
        alf.add('f');
        alf.add('g');
        alf.add('h');
        alf.add('j');
        alf.add('k');
        alf.add('l');
        alf.add('m');
        alf.add('n');
        alf.add('p');
        alf.add('q');
        alf.add('r');
        alf.add('s');
        alf.add('t');
        alf.add('v');
        alf.add('w');
        alf.add('x');
        alf.add('y');
        alf.add('z');
        String[] word = null;
        word = original.split(" ");
        String port = "";
        for (int k = 0; k < word.length; k++) {
            StringBuffer sb = new StringBuffer(word[k].toLowerCase());
            int cute = 0;
            for (int q=0; q<sb.length();q++) {
                if (alf.contains(sb.charAt(q))) {
                    cute = cute + 1;
                }
            }
            if (cute>0) {
                    if (word[k].length() > 1) {
                        for (int a = 0; a < sb.length()-1; a++) {
                            if (alf.contains(sb.charAt(a)) && !al.contains(sb.charAt(a+1)) ) {
                                    sb.replace(a+1, a + 2, "");
                                    a--;
                                }
                        }
                        for (int a = 0; a < sb.length(); a++) {
                            if (al.contains(sb.charAt(a))) {
                                sb.replace(a, a + 1, "");
                                a--;
                            }
                        }
                    }
            }
            port += sb.toString();
            if (k != word.length - 1) {
                port += " ";
            }
        }
        String[] a = {"a","b"};
        String[] b = {"c","d"};
        ArrayList<String> list = new ArrayList<>();
        for (int k=0;k<a.length;k++){
            list.add(a[k]);
            list.add(b[k]);
        }
        System.out.println(list);
        return port;
    }
}

