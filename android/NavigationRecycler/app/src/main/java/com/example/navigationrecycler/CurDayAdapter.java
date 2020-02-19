package com.example.navigationrecycler;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CurDayAdapter extends RecyclerView.Adapter<CurDayAdapter.MainAdapter>{


    Context context;
    ArrayList<MyPlanClass> arrayList;

    public CurDayAdapter(Context context, ArrayList<MyPlanClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.curr_date_items, parent,false);

        return new MainAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter holder, int position) {


        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.text.setText(arrayList.get(position).getName());
        if(position%2==0){
          holder.layout.setBackgroundResource(R.drawable.curr_dairy_item_1);
         }
        else
        {

            holder.layout.setBackgroundResource(R.drawable.curr_dairy_item_3);


        }



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainAdapter extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        ConstraintLayout layout;


        public MainAdapter(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView2);
            text = itemView.findViewById(R.id.textView5);
            layout = itemView.findViewById(R.id.layout);











        }
    }


}
