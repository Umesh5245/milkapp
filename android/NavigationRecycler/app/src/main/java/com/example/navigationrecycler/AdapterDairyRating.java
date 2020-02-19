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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterDairyRating extends RecyclerView.Adapter<AdapterDairyRating.MainAdapter>{


    Context context;
    ArrayList<String> arrayList;

    public AdapterDairyRating(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_user_dairy_review, parent,false);

        return new MainAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter holder, int position) {


//        holder.image.setImageResource(arrayList.get(position).getImage());
//        holder.text.setText(arrayList.get(position).getName());
//        holder.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,DairyProfileActivity.class);
//                context.startActivity(intent);
//            }
//        });




        if(position%2==0){
            holder.layout.setBackgroundResource(R.drawable.curr_review_1);
        }
        else
        {

            holder.layout.setBackgroundResource(R.drawable.curr_dairy_item_2);


        }







    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainAdapter extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        Button btn;
        ConstraintLayout layout;


        public MainAdapter(@NonNull View itemView) {
            super(itemView);
//            image = itemView.findViewById(R.id.imageView2);
//            text = itemView.findViewById(R.id.textView5);
//            btn = itemView.findViewById(R.id.viewDairy);
            layout = itemView.findViewById(R.id.layout);












        }
    }


}
