package com.example.navigationrecycler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TextView myPlan;
    private ArrayList<String> arrayList3 = new ArrayList<>();
    private TextView myCalendar;
    private ArrayList<SideNavClass> arrayList = new ArrayList<>();
    private ArrayList<SideNavClass> arrayList2 = new ArrayList<>();
    private FragmentTransaction fragmentTransaction;
    ImageView img_wallet;
    DrawerLayout drawerLayout;
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;




    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void scheduleNotification (Notification notification , int delay) {
        Intent notificationIntent = new Intent( this, MyNotificationPublisher. class ) ;
        notificationIntent.putExtra(MyNotificationPublisher. NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(MyNotificationPublisher. NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent. getBroadcast ( this, 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context. ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }


    private Notification getNotification (String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;
        builder.setContentTitle( "Pending Bill" ) ;
        builder.setContentText(content) ;
        builder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
        builder.setAutoCancel( true ) ;
        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
        return builder.build() ;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);



        if (!isNetworkConnected()) {

            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.drawerLayout), "No Internet", Snackbar.LENGTH_LONG);


            snackbar.setDuration(100000);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor("#464D55"));
            snackbar.show();


        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.registerNetworkCallback(
                    new NetworkRequest.Builder().build(),
                    new ConnectivityManager.NetworkCallback() {

                        @Override
                        public void onAvailable(Network network) {
                            super.onAvailable(network);
                            Snackbar snackbar = Snackbar
                                    .make(findViewById(R.id.drawerLayout), "Online", Snackbar.LENGTH_SHORT);

                            View snackBarView = snackbar.getView();
                            snackBarView.setBackgroundColor(Color.parseColor("#008577"));


                            snackbar.show();



                            // ...
                        }

                        @Override
                        public void onLost(Network network) {
                            super.onLost(network);

                            Snackbar snackbar = Snackbar
                                    .make(findViewById(R.id.drawerLayout), "No Internet", Snackbar.LENGTH_LONG);
                            snackbar.setDuration(100000);
                            View snackBarView = snackbar.getView();
                            snackBarView.setBackgroundColor(Color.parseColor("#464D55"));
                            snackbar.show();





                            // ...
                        }

                    });
        }


        drawerLayout = findViewById(R.id.drawerLayout);
//        final Snackbar snackbar = Snackbar.make(drawerLayout, "You have bill pending", Snackbar.LENGTH_LONG);
//        snackbar.setDuration(100000);
//        snackbar.setAction("OK", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                snackbar.dismiss();
//            }
//        });


//
//        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout)snackbar.getView();
//        layout.setMinimumHeight(100);
//
//        snackbar.show();

        img_wallet = findViewById(R.id.img_wallet);
        img_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WalletActivity.class);
                startActivity(intent);
            }
        });



        scheduleNotification(getNotification( "You have bill of 1000" ) , 3000 ) ;


        Window window = getWindow();




        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorStatus));
        }

//        Toast.makeText(this, getResources().getDisplayMetrics().density+"", Toast.LENGTH_LONG).show();



        TextView textView1 = findViewById(R.id.main_My_Plan);
        TextView textView2 = findViewById(R.id.main_My_Calendar);


        textView1.setTextColor(Color.parseColor("#ffaa66cc"));
        textView2.setBackgroundColor(Color.parseColor("#ffaa66cc"));
        textView2.setTextColor(Color.parseColor("#ffffff"));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        }


//myPlan fragment initialise

        myPlan = findViewById(R.id.main_My_Plan);
        myPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MyPlanFragment(),null).addToBackStack("4").commit();

//                getSupportFragmentManager().beginTransaction().add(R.id.frame_main,new MyPlanFragment()).addToBackStack("1").commit();


                TextView textView1 = findViewById(R.id.main_My_Plan);
                TextView textView2 = findViewById(R.id.main_My_Calendar);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    textView1.setTextColor(Color.parseColor("#ffffff"));

//                    textView1.setBackgroundColor(Color.parseColor("#ffaa66cc"));
                    textView2.setTextColor(Color.parseColor("#ffaa66cc"));


                    textView1.setBackgroundColor(Color.parseColor("#ffaa66cc"));

                    textView1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffaa66cc")));


                    textView2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));



                }
//9d03fc

                // Toast.makeText(MainActivity.this,"hello world",Toast.LENGTH_SHORT ).show();




            }
        });


       myCalendar =  findViewById(R.id.main_My_Calendar);
        myCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                getSupportFragmentManager().popBackStack();



                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,new CalendarFragment()).commit();


                TextView textView1 = findViewById(R.id.main_My_Plan);
                TextView textView2 = findViewById(R.id.main_My_Calendar);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    textView2.setTextColor(Color.parseColor("#ffffff"));



                    textView1.setTextColor(Color.parseColor("#ffaa66cc"));

                    textView2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffaa66cc")));
                    textView2.setBackgroundColor(Color.parseColor("#ffaa66cc"));
                    textView2.setTextColor(Color.parseColor("#ffffff"));



                    textView1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));



                }




            }
        });










        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

       getSupportFragmentManager().beginTransaction().add(R.id.frame_main, new CalendarFragment()).commit();



        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close);




        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        SideNavClass s1 = new SideNavClass("Wallet",R.drawable.ic1);
        SideNavClass s2 = new SideNavClass("Calendar",R.drawable.ic2);
        SideNavClass s3 = new SideNavClass("View Bill",R.drawable.ic3);
        SideNavClass s4 = new SideNavClass("Vacations",R.drawable.ic4);
        SideNavClass s5 = new SideNavClass("Help",R.drawable.ic6);
        SideNavClass s6 = new SideNavClass("Dairy",R.drawable.ic5);
        SideNavClass s7 = new SideNavClass("Help",R.drawable.ic7);
        SideNavClass s9 = new SideNavClass("Logout",R.drawable.ic8);
        SideNavClass s8 = new SideNavClass("Profile",R.drawable.ic9);
        SideNavClass s10 = new SideNavClass("Offers",R.drawable.ic10);


        arrayList.add(s1);arrayList.add(s2);arrayList.add(s3);arrayList.add(s4);arrayList.add(s5);arrayList2.add(s6);arrayList2.add(s7);arrayList2.add(s8);arrayList2.add(s9);arrayList2.add(s10);





        FragmentManager fragmentManager = getSupportFragmentManager();

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        MainAdapter mainAdapter =  new MainAdapter(arrayList, MainActivity.this,drawerLayout,fragmentManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mainAdapter);


        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        MainAdapter2 mainAdapter2 =  new MainAdapter2(arrayList2, MainActivity.this,drawerLayout,fragmentManager);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        recyclerView2.setAdapter(mainAdapter2);

   }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        FragmentManager fragmentManager = getSupportFragmentManager();

    int count = fragmentManager.getBackStackEntryCount();


    if(count==0){

    }

    else
    {
        while (count!=0)
        {

            fragmentManager.popBackStack();
            count--;


        }

        TextView textView1 = findViewById(R.id.main_My_Plan);
        TextView textView2 = findViewById(R.id.main_My_Calendar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView2.setTextColor(Color.parseColor("#ffffff"));



            textView1.setTextColor(Color.parseColor("#ffaa66cc"));

            textView2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffaa66cc")));
            textView2.setBackgroundColor(Color.parseColor("#ffaa66cc"));
            textView2.setTextColor(Color.parseColor("#ffffff"));



            textView1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));



        }



  //     getSupportFragmentManager().beginTransaction().add(R.id.frame_main, new CalendarFragment(),null).commit();





    }










    }
}
