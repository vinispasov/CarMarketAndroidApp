package com.example.lenovo.androidapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.androidapp.car_brands.Brand;
import com.example.lenovo.androidapp.car_brands.Counter;
import com.example.lenovo.androidapp.car_brands.Generation;
import com.example.lenovo.androidapp.car_brands.repositories.FirebaseRepository;
import com.example.lenovo.androidapp.car_brands.repositories.base.Repository;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Navigator mNavigator;
    private ArrayAdapter<String> mCarsAdapter;
    private ArrayAdapter<Brand> mBrandsList;
    private ListView mCarsListView;
    private Repository<Generation> mCarsRepository;
    private Generation currentGeneration;
    private Counter mCounter;
    private View mProgressBarForm;


    public CarsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View view= inflater.inflate(R.layout.fragment_cars_list, container, false);
            mProgressBarForm = view.findViewById(R.id.progress_bar_form);



        mCarsListView=view.findViewById(R.id.cars_list);
        mCarsAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1);
        mBrandsList=new ArrayAdapter<Brand>(getContext(),android.R.layout.simple_list_item_1);
        mCounter=new Counter();

        mCarsListView.setAdapter(mCarsAdapter);

        mCarsListView.setOnItemClickListener(this);
        mCarsRepository = new FirebaseRepository<>(Generation.class);

        //default Activity load
        if (currentGeneration==null) {
            Counter.setCounter(1);

            mCarsRepository.getAll(generations -> {
                // Hide Loader
                hideLoader();
                for (Generation generation : generations) {
                    if (generation.name.equals("First Generation")) {
                        mBrandsList.addAll(generation.brands);
                        mCarsAdapter.addAll(generation.getCarBrandsName());
                        break;
                    }
                }
            });
        }
        else{
            hideLoader();
            mBrandsList.addAll(currentGeneration.brands);
            mCarsAdapter.addAll(currentGeneration.getCarBrandsName());
        }

        return view;
    }

    private void hideLoader() {
        mProgressBarForm.setVisibility(View.GONE);
        mCarsListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Brand brand=mBrandsList.getItem(position);
        mNavigator.navigateWith(brand);
    }

    public static CarsListFragment newInstance() {
        return new CarsListFragment();
    }

    public void setNavigator(Navigator navigator){
        mNavigator=navigator;
    }

    public Repository<Generation> getmCarsRepository() {
        return mCarsRepository;
    }

    public void setCurrentGeneration(Generation currentGeneration) {
        this.currentGeneration = currentGeneration;
    }
}
