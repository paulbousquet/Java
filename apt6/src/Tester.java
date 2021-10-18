import java.util.*;

public class Tester {
    public static void main(String args[]) {
        ListNode welp = new ListNode(1, new ListNode(2));
        DM5 ohh = new DM5();
        ListNode food = ohh.mist(welp);
        ListNode q = food.next;
        System.out.print(food.next.next.next.info);
    }
}
