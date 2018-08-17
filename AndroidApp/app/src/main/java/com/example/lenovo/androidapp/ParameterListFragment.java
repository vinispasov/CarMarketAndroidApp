package com.example.lenovo.androidapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.androidapp.car_brands.Model;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParameterListFragment extends Fragment {


    private ListView mParametersistView;
    private ArrayAdapter<String> mParametersAdapter;
    private Model mModel;

    public ParameterListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_parameter_list, container, false);

        mParametersistView=view.findViewById(R.id.parameters);
        mParametersAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1);

        mParametersistView.setAdapter(mParametersAdapter);

        mParametersAdapter.addAll("MODEL: "+mModel.model,"YEARS: "+mModel.years,"ENGINE MODIFICATIONS: "+mModel.modifications,"BODY STYLE: "+mModel.bodyStyle,"PRICE: "+mModel.price);

        return view;
    }

    public static ParameterListFragment newInstance() {
        return new ParameterListFragment();
    }

    public void setModel(Serializable model) {
        mModel = (Model) model;
    }
}
