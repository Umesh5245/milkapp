package com.example.navigationrecycler;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.MyAdapter> {

    public WalletAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    private ArrayList<String> arrayList;

    Context context;

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_wallet, parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, final int position) {






    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {


        public MyAdapter(@NonNull View itemView) {
            super(itemView);

        }
    }








}

