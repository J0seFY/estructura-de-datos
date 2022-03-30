import java.util.concurrent.ThreadLocalRandom;

public class ElementosMayoresPromedio {


    /*algoritmo para solucionar ejercicio,recibe como entrada
        la cabeza de la lista enlazada anteriormente creada y
        retorna la cabeza de la nueva lista
     */

    public static void main(String[] args) {
        Node head = new Node(0);
        Node pointer = head;

        int min = 1;
        int max = 10;
        for(int i=min ; i <= max ; i++){

            pointer.next = new Node(ThreadLocalRandom.current().nextInt(min,max) + min);
            pointer = pointer.next;

        }

        pointer = head;
        while (pointer != null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }

        pointer = elementosMayoresAlPromedio(head);

        while (pointer != null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }


    }
    public static Node elementosMayoresAlPromedio(Node head){

        /*primero se crea un algoritmo para calcular el promedio de todos
        los elementos de la lista
         */

        int size = 0;
        int sum = 0;
        Node pointer = head;
        while(pointer != null){
            size++;
            sum += pointer.val;
            pointer = pointer.next;
        }

        int promedio = sum/size;

        System.out.println("size: " + size + " sum: " + sum + " promedio: " + promedio);

        /*el siguiente ciclo se utiliza para obtener la nueva
        cabeza
         */
        while(promedio >= head.val){
            head = head.next;
        }

        /*se crea un pointer para ir moviendonos a traves de la lista enlazada
        y otro Node llamado newList en el cual iremos enlazando la nueva lista
         */
        pointer = head;
        Node newList = head;

        /*en vista que ya hicimos un proceso para que asegurarnos que la cabecera
        es superior al promedio las comparaciones las hacemos a partir del nodo siguiente
         */
        while (pointer.next != null){
            if(pointer.next.val > promedio ){

                newList.next = pointer.next;
                newList = newList.next;
            }

            pointer = pointer.next;
        }


        //por ultimo se necesita un algoritmo capaz de ordenar la lista

        return head;




    }
}
