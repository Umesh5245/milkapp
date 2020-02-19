package com.example.navigationrecycler;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrDayFragment extends AppCompatActivity {

private ArrayList<MyPlanClass> arrayList;
private TextView txt_date;


    public CurrDayFragment() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_curr_day);

        txt_date = findViewById(R.id.date);


         String date =  getIntent().getStringExtra("date");
         txt_date.setText(date);



        MyPlanClass c1 = new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c2 = new MyPlanClass("Curd", R.drawable.curd);
        MyPlanClass c3 = new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c4 = new MyPlanClass("Curd", R.drawable.curd);
        MyPlanClass c5 = new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c6 = new MyPlanClass("Curd", R.drawable.curd);
        MyPlanClass c7 = new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c8 = new MyPlanClass("Curd", R.drawable.curd);
        MyPlanClass c9 = new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c10 = new MyPlanClass("Curd", R.drawable.curd);
        MyPlanClass c11= new MyPlanClass("Milk",R.drawable.milk);
        MyPlanClass c12 = new MyPlanClass("Curd", R.drawable.curd);

        arrayList = new ArrayList<>();






        arrayList.add(c1);arrayList.add(c2);arrayList.add(c3);arrayList.add(c4);arrayList.add(c5);arrayList.add(c6);
         arrayList.add(c1);arrayList.add(c2);arrayList.add(c3);arrayList.add(c4);arrayList.add(c5);arrayList.add(c6);

        CurDayAdapter adapter = new CurDayAdapter(this,arrayList);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
