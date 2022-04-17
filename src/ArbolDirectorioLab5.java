import java.util.LinkedList;
import java.util.StringTokenizer;

public class ArbolDirectorioLab5 {

    private  int size;

    private class Carpeta{
        String nombre;
        LinkedList<Carpeta> hijos;
        public Carpeta(String nombre) {
            this.nombre = nombre;
            hijos = new LinkedList<Carpeta>();
        }
    }

    private Carpeta root;

    public ArbolDirectorioLab5() {
        root = new Carpeta("root");
        size = 1;

    }

    /*
     * Dado un path del formato 'root/carpeta_1/.../carpeta_n', retornar el objeto CarpetaN
     * En caso de no encontrarlo, retornar Null
     */
    private Carpeta ir(String path) {
        StringTokenizer stPath = new StringTokenizer(path,"/");
        String nombreCarpeta;
        if(stPath.countTokens() == 1) return root;
        stPath.nextToken();
        Carpeta c = root;
        boolean encontrado = false;
        while(stPath.hasMoreTokens()) {
            nombreCarpeta = stPath.nextToken();
            encontrado = false;
            for(Carpeta h : c.hijos) {
                if(h.nombre.equals(nombreCarpeta)) {
                    c = h;
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado) return null;
        }
        return c;

    }

    /*
     * Retornar la cantidad total de carpetas que posee el �rbol de directorios
     */
    public int size() {

        return size;
    }

    /*
     * Dado un path del formato 'root/carpeta_1/.../carpeta_n' y un nombre de nueva carpeta, crear una nueva carpeta al
     * interior de la CarpetaN y retornar true
     * Si no se consigue, retornar false
     * CONDICION: no pueden haber dos carpetas en el mismo directorio con el mismo nombre
     */
    public boolean crearCarpeta(String path, String nombre) {
        StringTokenizer pathStr = new StringTokenizer(path,"/");

        Carpeta h = root;
        String nombreCarpeta="";
        while (pathStr.hasMoreTokens()){
             nombreCarpeta = pathStr.nextToken();
                for (Carpeta c : h.hijos) {
                    if (c.nombre.equals(nombreCarpeta)) {
                        h = c;
                    }
                }
        }

        if( !isCarpeta(h.hijos,nombre) && nombreCarpeta.equals(h.nombre)) {
            h.hijos.add(new Carpeta(nombre));
            size++;
            return true;
        }


        return false;

    }

    /*
     * Mover la carpeta a la que apunta path1 ('root/carpeta_1/.../carpeta_n') al interior de la carpeta apuntada por
     * path2 ('root/carpeta_1/.../carpeta_m'), de tal forma que las subcarpetas de carpetaN sean movidas como subcarpetas de
     * CarpetaM.
     * En caso de conseguirlo, retornar true, si no, retornar false
     * CONDICION: no pueden haber dos carpetas en el mismo directorio con el mismo nombre.
     * Si se da el caso, cancele toda la operaci�n
     */
    public boolean mover(String path1, String path2) {


        Carpeta carpetaQueSeMueve = ir(path1);

        Carpeta moverAqui = ir(path2);
        if(moverAqui == null || carpetaQueSeMueve == null || isCarpeta(moverAqui.hijos, carpetaQueSeMueve.nombre) ){
            return false;
        }
        eliminarCarpeta(path1);
        moverAqui.hijos.add(carpetaQueSeMueve);
        size += carpetaQueSeMueve.hijos.size() + 1;

        return true;
    }

    /*
     * Dada una lista de hermanos, averiguar si en su interior se encuentra una con el nombre entregado como par�metro
     */
    private boolean isCarpeta(LinkedList<Carpeta> hermanos, String nombre) {
        for(Carpeta h : hermanos) {
            if(h.nombre.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Eliminar la carpeta carpetaN ubicada en path ('root/carpeta_1/.../carpeta_n') junto a todo su subarbol
     * Usted elige la politica de eliminaci�n del nodo raiz
     */
    public boolean eliminarCarpeta(String path) {

        if(path.equals("root")){
            root.hijos.clear();
            root = null;
            return true;
        }


        String pathAntes = path.substring(0,path.lastIndexOf("/"));

        Carpeta padre = ir(pathAntes);
        Carpeta borrar = ir(path);

        if(borrar != null && padre != null){

            size -= borrar.hijos.size() + 1;
            padre.hijos.remove(borrar);

            return true;
        }

        return false;

    }

    public void print() {
        System.out.println("==================");
        System.out.println(root.nombre);
        print(root, 1);
        System.out.println("==================");
    }

    private void print(Carpeta c, int nivel) {
        String l = "";
        for(int i = 0; i < nivel; i++) l += "-";

        for(Carpeta h : c.hijos) {
            System.out.println(l+h.nombre);
            print(h, nivel+1);
        }
    }

}
