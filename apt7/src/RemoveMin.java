public class RemoveMin {
    public ListNode remove (ListNode list) {
        ListNode stor = list;
        if (list==null){
            stor = null;
        }
        else{
            if (list.next==null){
                stor = null;
            }
            else{
                int lop = list.info;
                ListNode place = copy(list);
                while (place!=null){
                    if (place.info<=lop){
                        lop = place.info;
                    }
                    place = place.next;
                }
                ListNode cop = copy(list);
                ListNode second_last = cop;
                while (second_last.next.info != lop){
                    if (second_last!=null){
                        second_last = second_last.next;
                    }
                    if (second_last.next==null){
                        break;
                    }
                }
                ListNode link = null;
                if (second_last.next==null){
                    link = copy(cop.next);
                }
                else{
                    ListNode rem = copy(second_last.next.next);
                    second_last.next = null;
                    link = copy(cop);
                    last(link).next = copy(rem);
                }
                stor = link;
            }
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