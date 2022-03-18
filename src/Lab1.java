public class Lab1 {

    private int fecha;

    public Lab1() {

        fecha = 0;
    }

    public void setAno(int anio){

        if(anio >= 0 && anio < 4096 ){

            int mask = 511;
            fecha = (fecha & mask) | (anio << 9);
        }
    }

    public int getAno(){

        return fecha >>> 9;
    }

    public void setMes(int mes){

        if(mes >= 0 && mes <= 12 ){
            int mask = 2096671;
            fecha = (fecha & mask) | mes << 5;
        }
    }

    public int getMes(){

        return (fecha << 23 )>>> 28;
    }

    public void setDia(int dia){

        if(dia >= 0 && dia <= 31){

            int mask = 2097120;
            fecha = (fecha & mask) | dia ;

        }
    }

    public int getDia(){

        return (fecha << 27) >>> 27;
    }


    public String toString(){


        return getDia() + "/" + getMes() + "/" + getAno();
    }


}



