class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
        return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!minHeap.isEmpty()){

            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}