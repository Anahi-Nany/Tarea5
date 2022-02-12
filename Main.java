package com.company;

class Time{
private int hour;
private int minute;
private int second;

//Construct
Time(int hour, int minute, int second){
    this.hour=hour;
    this.minute=minute;
    this.second=second;
    checkTime();
}

//setters
    public void setTime(int hour, int minute, int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
        checkTime();
    }

    //getters
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }


//add
    public void addHour(int delta){
    hour += delta;
    if(hour > 24 || hour <  0 ){
        hour= Math.abs(hour % 24);
    }
    }

    public void addMinute(int delta){
        minute += delta;

        if(minute / 60 < 0)
        { addHour((minute/60)-1);
        }else
        {
            addHour( minute / 60);
        }
        minute = minute % 60;
    }

    public void addSecond(int delta){
        second += delta;
        if(second/60 < 0)
        {
            addMinute((second/60)-1);

            //if(hour=0 && min==0 && seg< 0)
        }else
        {
            addMinute( second / 60);
        }
        second = second % 60;
    }

    //¿Cómo indicar que los valores pasados a setTime o el constructor son válidos?
    public void checkTime () {
        addHour(0);
        addMinute(0);
        addSecond(0);
    }

    public String toString(){
    return String.format("%02d : %02d : %02d", hour, minute, second);
    }
}

//=nombre del archivo
public class Main {

    public static void main(String[] args) {

        Time time = new Time (7,8,77);


        System.out.println("Valores del Ejemplo 1: "+ time.toString());


        time.addHour(10);
        System.out.println("Agregando Horas = 10 -> "+ time.toString());
        time.addMinute(15);
        System.out.println("Agregando Minutos = 15 -> "+ time.toString());
        time.addSecond(60);
        System.out.println("Agregando Minutos = 60 -> ");

        System.out.println("FINAL: " + time.getHour() + " : " + time.getMinute() + " : " + time.getSecond());

        time.setTime(54,6,77);
        System.out.println("\n" + "Valores del Ejemplo 2 : "+ time.toString());

        time.addHour(-45);
        System.out.println("Agregando Horas = -45 -> "+ time.toString());
        time.addMinute(-10);
        System.out.println("Agregando Minutos = -10 -> "+ time.toString());
        time.addSecond(6);
        System.out.println("Agregando Minutos = 6 ");

        System.out.println("FINAL: " + time.getHour() + " : " + time.getMinute() + " : " + time.getSecond());
    }
}
