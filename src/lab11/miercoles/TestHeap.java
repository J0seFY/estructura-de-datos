package lab11.miercoles;

import lab11.miercoles.MaxHeap;

public class TestHeap {

    public static void main(String[] args) {

        int [] n = {30,48,15,67,24,17,5};

        MaxHeap max = new MaxHeap(n);

        max.printHeap();
    }
}
