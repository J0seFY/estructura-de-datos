public class TimeDate {

    private int fecha;

    public TimeDate() {

        fecha = 0;
    }

    public void setAno(int anio){

        if(anio >= 0 && anio < 4096 ){

            int mask = 1048575;
            fecha = (fecha & mask) | (anio << 20);
        }
    }

    public int getAno(){

        return fecha >>> 20;
    }

    public void setMes(int mes){

        if(mes >= 0 && mes <= 12 ){
            int mask = -983041;
            fecha = (fecha & mask) | mes << 5;

        }
    }

    public int getMes(){

        return (fecha << 12 )>>> 28;
    }

    public void setDia(int dia){

        if(dia >= 0 && dia <= 31){

            int mask = -63489;
            fecha = (fecha & mask) | dia << 11 ;

        }
    }

    public int getDia(){

        return (fecha << 16) >>> 27;
    }


    public void setHora(int hora){

        if(hora >= 0 && hora <=23){

            int mask = -1985;
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

    public boolean sameDate(TimeDate t){
        if(getAno() == t.getAno() && getDia() == t.getDia() && getMes() == t.getMes()){

            return true;
        }else{
            return false;
        }
    }

    public boolean isBefore(TimeDate t){


        if(t.getAno() < getAno()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() < getMes()){
            return true;
        }else if(t.getAno() == getAno() && t.getMes() == getMes() && t.getDia() < getDia()){
            return true;
        }

        return false;
    }

    public boolean isAfter(TimeDate t){

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



