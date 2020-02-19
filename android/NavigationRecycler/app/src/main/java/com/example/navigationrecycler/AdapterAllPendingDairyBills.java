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

public class AdapterAllPendingDairyBills extends RecyclerView.Adapter<AdapterAllPendingDairyBills.MainAdapter>{


    Context context;
    ArrayList<String> arrayList;

    public AdapterAllPendingDairyBills(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_user_all_pending, parent,false);

        return new MainAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter holder, int position) {




                holder.text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,UserBillGeneratedActivity.class);
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
//            image = itemView.findViewById(R.id.cardview_dairy_next_icon);
////            text = itemView.findViewById(R.id.textView5);
                text = itemView.findViewById(R.id.nxt_btn);












        }
    }


}
