package lab1;

public class TestTimeDateLab1 {

    public static void main(String[] args) {

        TimeDateLab1 fecha = new TimeDateLab1();
        TimeDateLab1 fechaNueva = new TimeDateLab1();

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



}
