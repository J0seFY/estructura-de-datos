public class testLab1 {

    public static void main(String[] args) {

        Lab1 fecha = new Lab1();

        fecha.setAno(1999);
        fecha.setMes(3);
        fecha.setDia(23);
        System.out.println(fecha.toString());
        fecha.setDia(9);
        fecha.setMes(2);
        fecha.setAno(2000);
        System.out.println(fecha.toString());
        fecha.setDia(11);
        System.out.println(fecha.toString());
    }
}
