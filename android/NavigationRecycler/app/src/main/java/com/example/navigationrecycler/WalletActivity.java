package com.example.navigationrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class WalletActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> arrayList;
    Button btn_addMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        recyclerView =findViewById(R.id.recyclerView);


        btn_addMoney = findViewById(R.id.addMoney);
        btn_addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WalletActivity.this,UserRatingActivity.class);
                startActivity(intent);
            }
        });

        Window window = getWindow();




        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#4c74ed"));
        }

        arrayList = new ArrayList<>();
        arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");arrayList.add("1");


        WalletAdapter mainAdapter =  new WalletAdapter(arrayList, WalletActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mainAdapter);



    }
}
