public class DM5 {
    public ListNode mist(ListNode list) {
        ListNode a = new ListNode(1, new ListNode(2));
        last(a).next = copy(a);
        return a;
    }
    /**
     * Returns a copy of parameter
     * @param list is linked list being copied
     * @return new node list that’s a copy of list
     */
    public ListNode copy(ListNode list) {
        if (list == null) return null;;
        return new ListNode(list.info, copy(list.next));
    }
    /**
     * Returns pointer to last node of list
     * @param list linked list of nodes
     * @return pointer to last node of list
     * @throws null pointer exception if list is null
     */
    public ListNode last(ListNode list) {
        while (list.next != null) {
            list = list.next;
        }
        return list;
    }
}
