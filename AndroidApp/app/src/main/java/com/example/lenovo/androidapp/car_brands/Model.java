package com.example.lenovo.androidapp.car_brands;


import java.io.Serializable;

public class Model implements Serializable {
    public String model;
    public String years;
    public String modifications;
    public String bodyStyle;
    public String price;

    public Model(){

    }

    public Model(String model,String years){
        this.model=model;
        this.years=years;
    }


}
