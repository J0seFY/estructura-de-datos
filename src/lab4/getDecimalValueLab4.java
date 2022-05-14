package lab4;

public class getDecimalValueLab4 {
    //ejercicio 1290 leetcode
        public int getDecimalValue(ListNode head) {
            //se inicia el numero asignandole el valor del primer lab3.nodo
            int numero = head.val;
            //se crea un ciclo en el que va avanzando a traves de la lista enlazada
            //al ser numeros binarios,es decir, 1 y 0 podemos utilizar los operadores de bit
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
      ListNode(int val) { this.val = val; }ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
