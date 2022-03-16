public class Solucion4Guia1 {
    public static int i=0;

    public static void main(String[] args) {
        addOne(3);
        addOne(1);
        System.out.println(i);
    }

    public static void addOne(int x){
        int mask=1;
        mask = 1<<x-1;
        i |= mask;
    }
}

