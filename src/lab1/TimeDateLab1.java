package lab1;

public class TimeDateLab1 {

    private int fecha;

    public TimeDateLab1() {

        fecha = 0;
    }

    public void setAno(int anio){

        if(anio >= 0 && anio < 4096 ){

            int mask = 1048575;//11111111111111111111
            // se usa para mantener todos los 0 y 1 que tenga el numero
            fecha = (fecha & mask) | (anio << 20);
        }
    }

    public int getAno(){

        return fecha >>> 20;
    }

    public void setMes(int mes){

        if(mes >= 0 && mes <= 12 ){
            int mask = -983041;//11111111111100001111111
            fecha = (fecha & mask) | mes << 5;

        }
    }

    public int getMes(){

        return (fecha << 12 )>>> 28;
    }

    public void setDia(int dia){

        if(dia >= 0 && dia <= 31){

            int mask = -63489;//1111111111111111000001111
            fecha = (fecha & mask) | dia << 11 ;

        }
    }

    public int getDia(){

        return (fecha << 16) >>> 27;
    }


    public void setHora(int hora){

        if(hora >= 0 && hora <=23){

            int mask = -1985;//1111100000111111
            fecha = (fecha & mask) | hora << 6;
        }

    }

    public int getHora(){

        return (fecha << 21)>>> 27;
    }

    public void setMinutos(int minutos){

        if(minutos >= 0 && minutos <= 59){

            int mask = -64;
            fecha = (fecha & mask) | minutos;
        }
    }

    public int getMinutos(){

        return (fecha << 26) >>> 26;
    }

    public boolean sameDate(TimeDateLab1 t){
        if(getAno() == t.getAno() && getDia() == t.getDia() && getMes() == t.getMes()){

            return true;
        }else{
            return false;
        }
    }

    public boolean isBefore(TimeDateLab1 t){


        if(t.getAno() < getAno()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() < getMes()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() == getMes() && t.getDia() < getDia()){
            return true;
        }

        return false;
    }

    public boolean isAfter(TimeDateLab1 t){

        if(t.getAno() > getAno()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() > getMes()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() == getMes() && t.getDia() > getDia()){
            return true;
        }

        return false;
    }


    public String toString(){


        return getDia() + "/" + getMes() + "/" + getAno() + " " + getHora() +":" + getMinutos();
    }


}



