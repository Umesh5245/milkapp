package com.example.navigationrecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter2 extends RecyclerView.Adapter<MainAdapter2.MyAdapter> {

    public MainAdapter2(ArrayList<SideNavClass> arrayList, Context context,DrawerLayout drawerLayout,FragmentManager fragmentManager) {
        this.arrayList = arrayList;
        this.context = context;
        this.drawerLayout = drawerLayout;
        this.fragmentManager = fragmentManager;
    }

    private ArrayList<SideNavClass> arrayList;
    DrawerLayout drawerLayout;
    Context context;
    FragmentManager fragmentManager;

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercontainer, parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, final int position) {

        holder.textView.setText(arrayList.get(position).getName());
        holder.imageView.setImageResource(arrayList.get(position).getIcon());

        try{

            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (position)
                    {
                        case 0:
                            Intent intent = new Intent(context,AllDairyActivity.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(context,IndividualDairyActivity.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent3 = new Intent(context,UserProfileActivity.class);
                            context.startActivity(intent3);
                            break;

                        case 3:
                            Intent intent2 = new Intent(context,UserBillGeneratedActivity.class);
                            context.startActivity(intent2);
                            break;
                        case 4:
                            Intent intent4 = new Intent(context,UserAllActivity.class);
                            context.startActivity(intent4);
                            break;


                    }


                }
            });



        }


        catch (Exception e)
        {



        }



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
            textView = itemView.findViewById(R.id.side_nav_text);
            imageView = itemView.findViewById(R.id.side_nav_icon);
//            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }








}
