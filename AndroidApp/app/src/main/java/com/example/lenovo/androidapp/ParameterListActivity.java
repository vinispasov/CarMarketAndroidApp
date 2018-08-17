package com.example.lenovo.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.example.lenovo.androidapp.car_brands.Model;

public class ParameterListActivity extends Activity {

    private ParameterListFragment mParameterListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter_list);

        mParameterListFragment=ParameterListFragment.newInstance();

        Intent intent=getIntent();

        mParameterListFragment.setModel(intent.getSerializableExtra("PARAMETERS"));

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.parameters_list,mParameterListFragment)
                .commit();
    }

}
