public class DoubleList {
    public ListNode bigify(ListNode list) {
        ListNode stor = null;
        if (list==null){
            stor=list;
        }
        else{
            ListNode place = copy(list);
            place.next = null;
            ListNode hold = null;
            while (list!=null) {
                ListNode que = copy(list);
                que.next = null;
                int lop = 0;
                while (lop != 1) {
                    last(que).next = copy(place);
                    lop += 1;
                }
                if (hold == null) {
                    hold = copy(que);
                } else {
                    last(hold).next = copy(que);
                }
                list = list.next;
                place = copy(list);
                if (place != null) {
                    place.next = null;
                }
            }
            stor = hold;
        }
        return stor;
    }
    public ListNode duplicate(ListNode list){
        last(list).next = copy(list);
        return list;
    }
    public ListNode copy(ListNode list) {
        if (list == null) return null;;
        return new ListNode(list.info, copy(list.next));
    }

    public ListNode last(ListNode list) {
        while (list.next != null) {
            list = list.next;
        }
        return list;
    }
}