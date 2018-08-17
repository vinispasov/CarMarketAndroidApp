package com.example.lenovo.androidapp.car_brands;

import java.io.Serializable;
import java.util.ArrayList;

public class Brand implements Serializable{
    public String carBrand;
    public ArrayList<Model> models;

    public Brand(){
        //empty constructor required
    }

    public Brand(String carBrand, ArrayList<Model> models){
        this.carBrand=carBrand;
        this.models=models;
    }

    public ArrayList<Model> getModels() {
        return models;
    }
}
