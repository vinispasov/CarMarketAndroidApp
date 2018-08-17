package com.example.lenovo.androidapp;

import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.androidapp.car_brands.Model;


import java.util.List;

public class ModelsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mModelsListView;
    private ArrayAdapter<String> mModelsAdapter;
    private List<Model> mModels;
    private INavigatorParameters mNavigator;

    public ModelsListFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_models, container, false);

        mModelsListView=view.findViewById(R.id.models);

        mModelsAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1);

        mModelsListView.setAdapter(mModelsAdapter);
        mModelsListView.setOnItemClickListener(this);

        for (Model model:mModels) {
            mModelsAdapter.add(model.model);
        }
        return view;
    }
    public static ModelsListFragment newInstance() {
        return new ModelsListFragment();
    }


    public void setModels(List<Model> models) {
        this.mModels = models;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Model model=mModels.get(position);
       mNavigator.navigateWith(model);
    }

    public void setNavigator(INavigatorParameters navigator){
        mNavigator=navigator;
    }
}

