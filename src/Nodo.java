public class Nodo {

    public int val;
    public Nodo next;

    public Nodo(int val) {
        this.val = val;
    }

    public Nodo(int val, Nodo next) {
        this.val = val;
        this.next = next;
    }

    public Nodo() {}
}
