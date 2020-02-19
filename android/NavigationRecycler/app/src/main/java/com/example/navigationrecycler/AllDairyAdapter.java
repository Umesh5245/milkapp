package com.example.navigationrecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AllDairyAdapter extends RecyclerView.Adapter<AllDairyAdapter.MainAdapter>{


    Context context;
    ArrayList<String> arrayList;

    public AllDairyAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_cardview_dairy_layout, parent,false);

        return new MainAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter holder, int position) {


//        holder.image.setImageResource(arrayList.get(position).getImage());
//        holder.text.setText(arrayList.get(position).getName());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DairyProfileActivity.class);
                context.startActivity(intent);
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DairyViewRatingActivity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainAdapter extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        Button btn;


        public MainAdapter(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cardview_dairy_next_icon);
//            text = itemView.findViewById(R.id.textView5);
            btn = itemView.findViewById(R.id.viewDairy);












        }
    }


}
