package com.example.navigationrecycler;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Individual_items extends RecyclerView.Adapter<Adapter_Individual_items.MyAdapter> {

    public Adapter_Individual_items(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.drawerLayout = drawerLayout;
        this.fragmentManager = fragmentManager;
    }

    private ArrayList<String> arrayList;
    DrawerLayout drawerLayout;
    Context context;
    FragmentManager fragmentManager;

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_individual_item, parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, final int position) {

//        holder.textView.setText(arrayList.get(position).getName());
//        holder.imageView.setImageResource(arrayList.get(position).getIcon());
//
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (position)
//                {
//                    case 0:
//                        Intent intent = new Intent(context,AllDairyActivity.class);
//                        context.startActivity(intent);
//                        break;
//
//
//
//                }
//
//
//            }
//        });




//        switch (position)
//        {
//            case 0:
//                Intent intent = new Intent(context,AllDairyActivity.class);
//                context.startActivity(intent);
//                break;
//
//
//
//
//
//
//        }








    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {

        private TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
//            textView = itemView.findViewById(R.id.side_nav_text);
//            imageView = itemView.findViewById(R.id.side_nav_icon);
//            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }








}
