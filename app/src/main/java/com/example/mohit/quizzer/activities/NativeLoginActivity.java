package com.example.mohit.quizzer.activities;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mohit.quizzer.R;
import com.example.mohit.quizzer.utils.ToastHelper;
import com.example.mohit.quizzer.utils.ValidatorUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by mohit on 08/02/17.
 */

@EActivity(R.layout.activity_native_login)
public class NativeLoginActivity extends BaseActivity  {

    @ViewById(R.id.signinEmailLayout)
    LinearLayout signinEmailLayout;
    @ViewById(R.id.signinPasswordLayout)
    LinearLayout signinPasswordLayout;
    @ViewById(R.id.signin_email)
    EditText signinEmail;
    @ViewById(R.id.signin_password)
    EditText signinPassword;
    @ViewById(R.id.signin_forgotPassword)
    TextView signinforgotPassword;
    @ViewById(R.id.signin_goToSignup)
    TextView signinGoToSignup;
    @ViewById(R.id.sign_request)
    Button signinnButton;

    String email= "";
    String password = "";
    boolean validEmail = true;
    boolean validPassword = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @AfterViews
    protected void initView(){

        layoutValidColorChange(signinEmailLayout);
        layoutValidColorChange(signinPasswordLayout);

        signinEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && !validEmail) {
                    layoutValidColorChange(signinEmailLayout);

                }
            }
        });
        signinEmail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!validEmail) {
                    layoutValidColorChange(signinEmailLayout);
                }
                return false;
            }
        });


        signinPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && !validEmail) {
                    layoutValidColorChange(signinPasswordLayout);

                }
            }
        });
        signinPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!validPassword) {
                    layoutValidColorChange(signinPasswordLayout);
                }
                return false;
            }
        });

    }

    @Click(R.id.sign_request)
    public void signinButtonClick(){
        email = signinEmail.getText().toString();

        if(ValidatorUtils.isEmailValid(email)){
            // email is valid
            layoutValidColorChange(signinEmailLayout);
            validEmail = true;
            return;
        }
        else{
            ToastHelper.showToast("Invalid Email");
            layoutErrorColorChange(signinEmailLayout);
            validEmail = false;
            // show the error message
        }
        password = signinPassword.getText().toString();
        if(password.isEmpty() || password.length() < 6){
            ToastHelper.showToast("Make strong password");
            layoutErrorColorChange(signinPasswordLayout);
            validPassword = false;
            return;
        }
        else{
            layoutValidColorChange(signinPasswordLayout);
            validPassword = true;
        }

        if(validEmail && validPassword){
            // go to next page
        }
    }

    private void layoutErrorColorChange(LinearLayout newLayout) {
        GradientDrawable drawable = (GradientDrawable) newLayout.getBackground();
        int color = Color.parseColor("#ED2973");
        drawable.setStroke(2, color);
    }

    private void layoutValidColorChange(LinearLayout validlayout) {
        GradientDrawable drawable = (GradientDrawable) validlayout.getBackground();
        drawable.setStroke(2,Color.parseColor("#E5E5E5"));
    }


}
