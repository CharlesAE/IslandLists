package com.srstudios.islandlists;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.srstudios.islandlists.Model.IslandModel;
import com.srstudios.islandlists.Util.IslandAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    IslandAdapter islandAdapter;
    public List<IslandModel> islandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.blue));
        collapsingToolbar.setStatusBarScrimColor(getResources().getColor(R.color.amber));


        recyclerView = (RecyclerView) findViewById(R.id.islandRecyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        islandList = new ArrayList<>();

        islandList.add(new IslandModel("Anguilla", R.drawable.anguilla));
        islandList.add(new IslandModel("Antigua & Barbuda", R.drawable.antigua));
        islandList.add(new IslandModel("Aruba", R.drawable.aruba));
        islandList.add(new IslandModel("Bahamas", R.drawable.bahamas));
        islandList.add(new IslandModel("Barbados", R.drawable.barbados));
        islandList.add(new IslandModel("Bonaire", R.drawable.bonaire));
        islandList.add(new IslandModel("British Virgin Islands", R.drawable.bvi));
        islandList.add(new IslandModel("Cayman Islands", R.drawable.cayman));
        islandList.add(new IslandModel("Cuba", R.drawable.cuba));
        islandList.add(new IslandModel("Curacao", R.drawable.curacao));
        islandList.add(new IslandModel("Dominica", R.drawable.dominica));

        islandAdapter = new IslandAdapter(islandList, this);
        recyclerView.setAdapter(islandAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_info:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}