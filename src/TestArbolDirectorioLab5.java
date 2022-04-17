public class TestArbolDirectorioLab5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArbolDirectorioLab5 ad = new ArbolDirectorioLab5();
        ad.print();

        System.out.println("Current size: " + ad.size());

        ad.crearCarpeta("root", "Carpeta 1");
        ad.crearCarpeta("root", "Carpeta 2");
        ad.crearCarpeta("root", "Carpeta 3");
        ad.crearCarpeta("root","Carpeta 2");
        ad.print();
        System.out.println("Current size: " + ad.size());

        ad.crearCarpeta("root/Carpeta 1", "Carpeta 4");
        ad.crearCarpeta("root/Carpeta 2", "Carpeta 2");
        ad.crearCarpeta("root/Carpeta 2", "Carpeta 5");
        ad.crearCarpeta("root/Carpeta 2", "Carpeta 4");
        ad.crearCarpeta("root/Carpeta 2/Carpeta 2","Carpeta 20");
        ad.print();

        System.out.println("Current size: " + ad.size());
        ad.eliminarCarpeta("root/Carpeta 1");
        ad.eliminarCarpeta("root/Carpeta 3/Carpeta 2");
        ad.print();
        System.out.println("Current size: " + ad.size());
        ad.mover("root/Carpeta 2/Carpeta 2","root/Carpeta 3");
        ad.print();
        System.out.println("Current size: " + ad.size());



    }

}
