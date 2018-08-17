package com.example.lenovo.androidapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.androidapp.car_brands.Brand;
import com.example.lenovo.androidapp.car_brands.Model;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelsListActivity extends AppCompatActivity implements INavigatorParameters{
    private ModelsListFragment mModelsListFragment;
    private List<Model> mModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models_list);

        mModelsListFragment=ModelsListFragment.newInstance();
        mModels=new ArrayList<Model>();
        mModelsListFragment.setNavigator(this);

        Intent intent=getIntent();


        mModels.addAll(intent.getParcelableArrayListExtra("MODELS"));

        mModelsListFragment.setModels(mModels);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_models,mModelsListFragment)
                .commit();



    }

    @Override
    public void navigateWith(Model model) {
        Intent intent=new Intent(
                this,
                ParameterListActivity.class
        );

        intent.putExtra("PARAMETERS",model);

        startActivity(intent);
    }


}
