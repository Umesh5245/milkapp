package com.example.navigationrecycler;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPlanFragment extends Fragment {

    private ArrayList<MyPlanClass> arrayList;


    public MyPlanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_plan, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);


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

        MyPlanAdapter adapter = new MyPlanAdapter(getContext(),arrayList);

        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);















    }
}
