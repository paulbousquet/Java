import java.util.PriorityQueue;

public class Tester {
    public static void main(String args[]) {
        ListNode welp = new ListNode(1, new ListNode(2));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(3);
        System.out.print(pq.remove());

    }
}
