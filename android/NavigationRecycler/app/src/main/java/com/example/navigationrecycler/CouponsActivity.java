package com.example.navigationrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CouponsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        recyclerView = findViewById(R.id.recyclerView);


        arrayList = new ArrayList<>();

        arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");



        CouponsAdapter adapter = new CouponsAdapter(this,arrayList);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);





    }
}
