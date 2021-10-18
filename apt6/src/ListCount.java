public class ListCount {
    public int count(ListNode list) {
        int math = 0;
        while (list != null) {
            math += 1;
            list = list.next;
        }
        return math;
    }

}