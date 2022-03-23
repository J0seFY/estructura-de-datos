public class TestTimeDate {

    public static void main(String[] args) {

        TimeDate fecha = new TimeDate();
        TimeDate fechaNueva = new TimeDate();

        fecha.setAno(1999);
        fecha.setMes(3);
        fecha.setDia(23);
        fecha.setHora(23);
        fecha.setMinutos(38);
        System.out.println(fecha.toString());

        fechaNueva.setAno(2022);
        fechaNueva.setMes(3);
        fechaNueva.setDia(23);

        if(fecha.isAfter(fechaNueva)){
            System.out.println("after");
        }
        }

        /*
        fecha.setDia(9);
        fecha.setMes(2);
        fecha.setAno(2000);
        System.out.println(fecha.toString());
        fecha.setDia(11);
        System.out.println(fecha.toString());

         */

}
