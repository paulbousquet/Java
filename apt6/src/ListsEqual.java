public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        int coo = 0;
        boolean fake = a1==null;
        boolean fak =  a2==null;
        if (fake || fak){
            if (fake && fak){
                coo = 1;
            }
            else{
                coo = 0;
            }
        }
        else {
            if (a1.next==null && a2.next==null){
                if(a1.info==a2.info){
                    coo = 1;
                }
                else{
                    coo = 0;
                }
            }
            else{
                while (a1.next != null || a2.next != null){
                    coo = 0;
                    if (a1.next == null || a2.next==null){
                        break;
                    }
                    if (a1.next.info!=a2.next.info){
                        break;
                    }
                    a1 = a1.next;
                    a2 = a2.next;
                    coo = 1;
                }
            }
        }
        return coo;
    }
}