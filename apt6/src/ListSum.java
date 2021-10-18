public class ListSum {
    public int sum(ListNode list, int thresh) {
        int math = 0;
        while (list != null) {
            if (list.info > thresh){
                math+=list.info;
            }
            list = list.next;
        }
        return math;
    }
}