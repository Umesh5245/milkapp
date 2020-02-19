package com.example.navigationrecycler;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class WelcomeActivity extends AppCompatActivity {



    ImageView bgapp, clover;
    LinearLayout textsplash;
    Animation frombottom;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Create a thread pool with a single thread//

        Executor newExecutor = Executors.newSingleThreadExecutor();

        FragmentActivity activity = this;


        //Start listening for authentication events//

        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(activity, newExecutor, new BiometricPrompt.AuthenticationCallback() {
            @Override

//onAuthenticationError is called when a fatal error occurrs//

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                } else {

//Print a message to Logcat//


                }
            }

//onAuthenticationSucceeded is called when a fingerprint is matched successfully//

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);


                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
                finish();


//Print a message to Logcat//

               // Log.d(TAG, "Fingerprint recognised successfully");
            }

//onAuthenticationFailed is called when the fingerprint doesn’t match//

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();



//Print a message to Logcat//

              //  Log.d(TAG, "Fingerprint not recognised");
            }
        });



        //Create the BiometricPrompt instance//

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()

//Add some text to the dialog//

                .setTitle("Fingerprint Authentication Required")

                .setDescription("Only registered fingers on this phone can unlock")
                .setNegativeButtonText("Cancel")

//Build the dialog//

                .build();



        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash =  findViewById(R.id.textsplash);




        bgapp.animate().translationY(-2900).setDuration(3200).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        //  textsplash.animate().translationY(140).alpha(0).setDuration(2800).setStartDelay(300);


        Window window = getWindow();




        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorSplash));



        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {



                myBiometricPrompt.authenticate(promptInfo);

                // This method will be executed once the timer is over

            }
        }, 2600);



    }
}