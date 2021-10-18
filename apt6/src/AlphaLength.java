import java.util.*;

public class AlphaLength {
    public ListNode create (String[] words) {
        SortedSet copy = new TreeSet();
        for (String i:words) copy.add(i);
        String[] lek = new String[copy.size()];
        for (int k=0;k<lek.length;k++){
            lek[k] = copy.toArray()[k].toString();
        }
        ListNode first = new ListNode(lek[0].length(),null);
        ListNode last = first;
        for (int i=1;i<lek.length;i++){
            last.next = new ListNode(lek[i].length(),null);
            last = last.next;
        }
        return first;
    }
}