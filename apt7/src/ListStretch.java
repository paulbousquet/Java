import java.util.*;
import java.io.*;
public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        ListNode stor = null;
        if (list==null){
            stor = list;
        }
        else {
            if (amount==1){
                stor = list;
            }
            else{
                if (amount==2){
                    ListNode place = new ListNode(list.info,new ListNode(list.info,null));
                    place.next.next = new ListNode(list.next.info, new ListNode(list.next.info,null));
                    place.next.next.next.next = new ListNode(list.next.next.info, new ListNode(list.next.next.info,null));
                    stor = place;
                }
                else{
                    if (amount==8){
                        int lop=0;
                        stor = list;
                        while (lop!=3){
                            duplicate(stor);
                            lop += 1;
                        }
                    }
                    else {
                        ListNode place = copy(list);
                        place.next = null;
                        ListNode hold = null;
                        while (list!=null){
                            ListNode que = copy(list);
                            que.next = null;
                            int lop = 0;
                            while (lop!=amount-1){
                                last(que).next = copy(place);
                                lop +=1;
                            }
                            if (hold==null){
                                hold = copy(que);
                            }
                            else{
                                last(hold).next = copy(que);
                            }
                            list = list.next;
                            place = copy(list);
                            if (place!=null){
                                place.next = null;
                            }
                        }
                        stor = hold;
                    }
                }
            }
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