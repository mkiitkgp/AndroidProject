package com.example.mohit.quizzer.activities;

import android.content.Intent;

import com.example.mohit.quizzer.R;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import com.example.mohit.quizzer.constants.AppConstants;
import com.example.mohit.quizzer.utils.AppUtils;
import com.example.mohit.quizzer.utils.SharedPreferenceHelper;


/**
 * Created by mohit on 08/02/17.
 */

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    @AfterViews
    protected void initViews(){
        handleAppIntro();
    }

    private void handleAppIntro() {
        boolean appIntroFlow = SharedPreferenceHelper.getBoolean(SharedPreferenceHelper.KEY_APP_INTRO_FLOW, false);
        boolean isUserSignedIn = AppUtils.isUserSignedIn();

        Intent intent = new Intent(this,NativeLoginActivity_.class);
        intent.putExtra(AppConstants.COMING_FROM , "SPLASH");
        startActivity(intent);

//        if(appIntroFlow){
//            // go to app intro flow
//        }
//        else{
//            if(isUserSignedIn){
//
//            }
//            else{
////                Intent intent = new Intent(this,NativeLoginActivity_.class);
////                intent.putExtra(AppConstants.COMING_FROM , "SPLASH");
////                startActivity(intent);
//            }
//        }
    }

}
