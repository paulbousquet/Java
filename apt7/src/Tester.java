import java.util.*;

public class Tester {
    public static void main(String args[]) {
        ListNode welp = new ListNode(1, new ListNode(2));
        ListNode que = null;
        que = welp;
        que.next = null;
        ListNode place = new ListNode(que.info,null);
        que.next = place;
        welp = que;
        System.out.println(welp.next);
    }
}