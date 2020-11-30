class LinkedListIntersection{
    public ListNode intersectionLinkedList(ListNode head){
        if(head==null){
            return null;
        }
        boolean loopExists=false;
        ListNode p=head;
        ListNode q=head;
        while(p!=null && q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
            if(p == q){
                loopExists = true;
            }
        }
        return loopExists ? p : null;
    }
    
    //Remove loop  
    
    public ListNode removeLoop(ListNode head, ListNode p, ListNode q){
        if(head==null){
            return null;
        }
        
        //p, q are passed such that they are pointing at the intresection point 
        //Let q be at the intersection node and let us start p from head to remove loop 
        p= head;
        while(p!=null && q!=null && p.next!=null && q.next!=null){
            p = p.next;
            q= q.next;
            if(p==q){
                //They meet, we need to remove the loop now 
                q.next=null;
            }
        }
        return head;
    }
}
