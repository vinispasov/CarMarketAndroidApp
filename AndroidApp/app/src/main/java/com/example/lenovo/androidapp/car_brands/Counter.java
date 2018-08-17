package com.example.lenovo.androidapp.car_brands;

public class Counter {
    public static int counter;

    public Counter(){
        counter+=0;
    }


    public static void setCounter(int counter) {
        Counter.counter += counter;
    }

    public static int getCounter() {
        return counter;
    }
}
