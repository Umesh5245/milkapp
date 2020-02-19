package com.example.navigationrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserRatingActivity extends AppCompatActivity {

    ConstraintLayout layout;
    TextView t1;
    RatingBar r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rating);



        t1 = findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                if(inflater == null) {
                    return;
                }
//View popupView = inflater.inflate(R.layout.my_popup_layout, null); // this version gives a warning cause it doesn't like null as argument for the viewRoot, c.f. https://stackoverflow.com/questions/24832497 and https://stackoverflow.com/questions/26404951
                View popupView = View.inflate(UserRatingActivity.this, R.layout.rating_popup, null);

// create the popup window
                final PopupWindow popupWindow = new PopupWindow(popupView,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        true // lets taps outside the popup also dismiss it
                );

// do something with the stuff in your popup layout, e.g.:
//((TextView)popupView.findViewById(R.id.textview_popup_helloworld))
//      .setText("hello stackoverflow");

// dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

// show the popup window
// which view you pass in doesn't matter, it is only used for the window token
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
//popupWindow.setOutsideTouchable(false); // doesn't seem to change anything for me

                View container = popupWindow.getContentView().getRootView();
                if(container != null) {
                    WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
                    WindowManager.LayoutParams p = (WindowManager.LayoutParams)container.getLayoutParams();
                    p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                    p.dimAmount = 0.7f;
                    if(wm != null) {
                        wm.updateViewLayout(container, p);
                    }
                }






//                layout = findViewById(R.id.constraintLayout);
//                LayoutInflater inflater = (LayoutInflater)
//                        getSystemService(LAYOUT_INFLATER_SERVICE);
//                View popupView = inflater.inflate(R.layout.rating_popup, null);
//
//                int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
//                int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
//                boolean focusable = true; // lets taps outside the popup also dismiss it
//                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//
//                ViewGroup root = (ViewGroup) getWindow().getDecorView().getRootView();
//
//                popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

            }
        });
        r1 = findViewById(R.id.r1);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout = findViewById(R.id.constraintLayout);
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.rating_popup, null);

                int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
                int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
                popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
            }
        });





        Window window = getWindow();




        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#4c74ed"));
        }

    }
}
