public class Solucion3Guia1 {

    private int datos;
    
    public Solucion3Guia1(){
    
        datos = 0;
        
    }

    public  void setDepositoDeLiquidos(int x){

        int mask =  x << 2;
        int borrador = 2147479555 | (1 << 31);
        datos = (datos & borrador) | mask;
    }

    public  int getDepositoDeLiquidos(){

        return (datos << 20) >>> 23;
    }


    public  void setTemperatura(int x){
        int mask = x << 20;
        int borrar = 8191;

        datos = (datos & borrar) | mask;
    }

    public  void setAcidez(int x){
        int mask = x<< 12;
        int borrar = 2146439167 | (1 << 31);
        datos = (datos & borrar) | mask;
    }

    public  int getAcidez(){

        return (datos << 12)>>>24;
    }

    public  int getTemp(){

        return (datos >>> 20);
    }
}
