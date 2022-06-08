package lab11.jueves;

public class TestMaxHeap {
    public static void main(String[] args) {

        MaxHeap max = new MaxHeap();
        //30,48,15,67,24,17,5
        max.insert(30);
        max.insert(48);
        max.insert(15);
        max.insert(67);
        max.insert(24);
        max.insert(17);
        max.insert(5);
        max.printHeap();
    }
}
