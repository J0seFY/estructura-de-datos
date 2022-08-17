package lab16;

public class testHashing {

    public static void main(String[] args) {
        Hashing h = new Hashing(28);
        h.insertar(28);
        Hashing.Nodo n  = h.buscar(28);
        System.out.println(n.key);
    }
}
