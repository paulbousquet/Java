public class ListLastFirst {
    public ListNode move(ListNode list) {
        ListNode stor = null;
        if (list==null || list.next==null){
            stor = list;
        }
        else{
            ListNode cop = copy(list);
            ListNode second_last = cop;
            while (second_last.next.next != null)
                second_last = second_last.next;
            second_last.next = null;
            ListNode fink = last(list);
            last(fink).next = copy(cop);
            stor = fink;
        }
        return stor;
    }
    public ListNode duplicate(ListNode list){
        last(list).next = copy(list);
        return list;
    }
    public ListNode copy(ListNode list) {
        if (list == null) return null;
        return new ListNode(list.info, copy(list.next));
    }

    public ListNode last(ListNode list) {
        while (list.next != null) {
            list = list.next;
        }
        return list;
    }
}