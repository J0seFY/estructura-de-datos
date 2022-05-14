package lab3;

public class ListaLab3 {

    private Nodo laCabeza;

    ListaLab3() {
        laCabeza = null;
    }

    //---Inserta un objeto(int) al comienzo de la lista
    public void InsertaInicio(int o) {
        if (EstaVacia()) laCabeza = new Nodo(o, null);
        else laCabeza = new Nodo(o, laCabeza);
    }

    //---- Inserta al final ----
    public void InsertaFinal(int o) {
        if (EstaVacia()) laCabeza = new Nodo(o, null);
        else {
            Nodo t;
            for (t = laCabeza; t.next != null; t = t.next) ;
            ;
            t.next = new Nodo(o, null);
        }
    }

    // ---cuenta la cantidad de nodos de la lista (Size)
    public int Size() {
        int tnodos = 0;
        for (Nodo t = laCabeza; t != null; t = t.next) tnodos++;
        return tnodos;
    }

    //eliminar un lab3.nodo de la lista
// Elimina el primer lab3.nodo n tal que o.elObjeto==o
    public void Eliminar(int o) {
        if (!EstaVacia()) {
            if (laCabeza.elObjeto == o) laCabeza = laCabeza.next;
            else {
                Nodo p = laCabeza;
                Nodo t = laCabeza.next;
                while (t != null && t.elObjeto != o) {
                    p = t;
                    t = t.next;
                }
                if (t.elObjeto == o) p.next = t.next;
            }
        }
    }

    // Verifica si la lista está vacias;
    public boolean EstaVacia() {
        return laCabeza == null;
    }

    //-----Imprime la lista-----
    public void Print() {
        if (laCabeza != null) Imprimir(laCabeza);
        else System.out.println("Lista Vacia");
    }

    void Imprimir(Nodo m) {
        if (m != null) {
            m.Print();
            Imprimir(m.next);
        }
    }

    //-----Clase Nodo---------
    class Nodo {
        public int elObjeto;
        public Nodo next;

        public Nodo(int nuevoObjeto, Nodo next) {
            this.elObjeto = nuevoObjeto;
            this.next = next;
        }

        public Nodo(int elObjeto) {
            this.elObjeto = elObjeto;
        }

        void Print() {
            System.out.print("- " + elObjeto);
        }
    }

    public Nodo getNodo(int pos){

        Nodo pointer = laCabeza;
        int aux = 0;
        while (pointer != null && aux != pos ){
            aux++;
            pointer = pointer.next;

        }
        return pointer;
    }

    public int promedio(){
        int sum=0;
        Nodo pointer = laCabeza;
        while (pointer != null) {
            sum += pointer.elObjeto;
            pointer = pointer.next;
        }

        if(Size() == 0){
            return sum;
        }
        return sum/Size();
    }
    public void elementosMayoresAlPromedio() {



        int promedio = promedio();



        /*el siguiente ciclo se utiliza para obtener la nueva
        cabeza
         */
        while (promedio >= laCabeza.elObjeto) {
            laCabeza = laCabeza.next;
        }

        /*se crea un pointer para ir moviendonos a traves de la lista enlazada
        y otro Node llamado newList en el cual iremos enlazando la nueva lista
         */
        Nodo pointer = laCabeza;
        Nodo newList = new Nodo(laCabeza.elObjeto);
        Nodo newListHead = newList;

        /*en vista que ya hicimos un proceso para que asegurarnos que la cabecera
        es superior al promedio las comparaciones las hacemos a partir del lab3.nodo siguiente
         */
        while (pointer.next != null) {
            if (pointer.next.elObjeto > promedio) {

                newList.next = new Nodo(pointer.next.elObjeto);
                newList = newList.next;
            }

            pointer = pointer.next;
        }

        laCabeza = newListHead;
    }

    public void sort(){

                // Node current will point to head
                Nodo current = laCabeza, index = null;

                int temp;

                if (laCabeza == null) {
                    return;
                }
                else {
                    while (current != null) {
                        // Node index will point to node next to
                        // current
                        index = current.next;

                        while (index != null) {
                            // If current node's data is greater
                            // than index's node data, swap the data
                            // between them
                            if (current.elObjeto > index.elObjeto) {
                                temp = current.elObjeto;
                                current.elObjeto = index.elObjeto;
                                index.elObjeto = temp;
                            }

                            index = index.next;
                        }
                        current = current.next;
                    }
                }
            }




}

