public class getDecimalValueLab4 {
        public int getDecimalValue(ListNode head) {

            int numero = head.val;

            while(head.next != null){
                head = head.next;

                numero = (numero << 1) | head.val;
            }

            return numero;

        }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
