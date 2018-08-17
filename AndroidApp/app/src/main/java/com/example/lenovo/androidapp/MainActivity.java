package com.example.lenovo.androidapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lenovo.androidapp.car_brands.Brand;
import com.example.lenovo.androidapp.car_brands.Counter;
import com.example.lenovo.androidapp.car_brands.Generation;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Navigator {

    private CarsListFragment mCarsListFragment;
    private Toolbar mToolbar;
    private Drawer mDrawer;
    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);
        mCarsListFragment= CarsListFragment.newInstance();

        setupDrawer();
        counter=new Counter();
        if (Counter.getCounter()!=0){
            Intent intent=getIntent();
            Generation generation= (Generation) intent.getSerializableExtra("GENERATION");
            mCarsListFragment.setCurrentGeneration(generation);
        }


        mCarsListFragment.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content,mCarsListFragment)
                .commit();



    }

    private void setupDrawer() {

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Generations");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName("First Generation");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem()
                .withIdentifier(3)
                .withName("Second Generation");
        SecondaryDrawerItem item4 = new SecondaryDrawerItem()
                .withIdentifier(4)
                .withName("Third Generation");
        SecondaryDrawerItem item5 = new SecondaryDrawerItem()
                .withIdentifier(5)
                .withName("Fourth Generation");

//create the drawer and remember the `Drawer` result object
        mDrawer  = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        item5
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long identifier=drawerItem.getIdentifier();
                        final int[] counter = new int[1];

                       mCarsListFragment.getmCarsRepository().getAll(generations -> {
                            for (Generation generation : generations) {
                                if (identifier==2&&generation.name.equals("First Generation")){
                                    counter[0] =1;
                                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                                    intent.putExtra("GENERATION",generation);
                                    startActivity(intent);
                                    break;
                                }
                                else if (identifier==3&&generation.name.equals("Second Generation")){
                                    counter[0] =1;
                                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                                    intent.putExtra("GENERATION",generation);
                                    startActivity(intent);
                                    break;
                                }
                                else if (identifier==4&&generation.name.equals("Third Generation")){
                                    counter[0] =1;
                                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                                    intent.putExtra("GENERATION",generation);
                                    startActivity(intent);
                                    break;
                                }
                                 else if (identifier==5&&generation.name.equals("Fourth Generation")){
                                    counter[0] =1;
                                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                                    intent.putExtra("GENERATION",generation);
                                    startActivity(intent);
                                    break;
                                }
                            }
                        });
                       if (counter[0]==1){
                           return true;
                       }
                       else{
                           return false;
                       }
                    }
                })
                .build();
    }


    @Override
    public void navigateWith(Brand brand) {
        Intent intent=new Intent(
                MainActivity.this,
                ModelsListActivity.class
        );

        intent.putExtra("MODELS",brand.getModels());

        startActivity(intent);
    }
}
