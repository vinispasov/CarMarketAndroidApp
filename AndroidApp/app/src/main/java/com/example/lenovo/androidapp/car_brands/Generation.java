package com.example.lenovo.androidapp.car_brands;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Generation implements Serializable {
    public String name;
    public List<Brand> brands;
    public  Generation(){
        //empty constructor required
    }

  public List<String> getCarBrandsName(){
        List<String> carBrandsNames=new ArrayList<>();
      for (Brand brand: brands) {
          carBrandsNames.add(brand.carBrand);
      }
      return carBrandsNames;
   }


}
