package lab3;

public class nodo {

    public int val;
    public nodo next;

    public nodo(int val) {
        this.val = val;
    }

    public nodo(int val, nodo next) {
        this.val = val;
        this.next = next;
    }

    public nodo() {}
}
