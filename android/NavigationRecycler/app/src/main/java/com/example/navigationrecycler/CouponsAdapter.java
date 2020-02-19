package com.example.navigationrecycler;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.MainAdapter>{


    Context context;
    ArrayList<String> arrayList;

    public CouponsAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_coupons, parent,false);

        return new MainAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter holder, int position) {


        if(position%2==0){
            holder.layout.setBackgroundResource(R.drawable.coupon1);
        }
        else
        {

            holder.layout.setBackgroundResource(R.drawable.coupon3);

        }



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainAdapter extends RecyclerView.ViewHolder{

        LinearLayout layout;


        public MainAdapter(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.linearLayout);











        }
    }


}


