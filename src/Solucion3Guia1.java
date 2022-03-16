import java.util.Scanner;

public class Solucion3Guia1 {

    public static int datos = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ignrese la temperatura");
        System.out.println();
        int temperatura = sc.nextInt();
        addTemperatura(temperatura);
        calcularTemp();

        System.out.println("ingrese la acidez");
        System.out.println();
        int acidez = sc.nextInt();
        addAcidez(acidez);
        calcularAcidez();



        System.out.println("ingrese el nivel del deposito de liquidos");
        int nivelDeposito = sc.nextInt();
        addDepositoDeLiquidos(nivelDeposito);
        calcularDepositoDeLiquidos();
    }

    public static void addDepositoDeLiquidos(int x){

        int mask =  x << 3;
        datos |= mask;
    }

    public static void calcularDepositoDeLiquidos(){

        int aux = datos << 20;
        aux = aux >> 23;
        System.out.println("el nivel de deposito de liquidos es " + aux);
    }


    public static void addTemperatura(int x){
        int mask = x << 20;

        datos |= mask;
    }

    public static void addAcidez(int x){
        int mask = x<< 12;
        datos |= mask;
    }

    public static void calcularAcidez(){

        int aux = datos << 12;
        aux = aux >> 24;
        System.out.println("la acidez es " + aux);
    }

    public static void calcularTemp(){

        int aux = datos >> 20;
        System.out.println("la temperatura es " + aux);
    }
}
