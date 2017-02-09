package com.example.mohit.quizzer.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.mohit.quizzer.activities.QZApplication;
import com.example.mohit.quizzer.constants.AppConstants;

/**
 * Created by mohit on 08/02/17.
 */

public class AppUtils {

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) QZApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return ((networkInfo != null) && networkInfo.isConnected());
    }

    public static boolean isUserSignedIn() {
        return SharedPreferenceHelper.getInt(SharedPreferenceHelper.KEY_SIGNIN_STATUS, -1) == AppConstants.SIGNIN_STATUS_SIGNED_IN;
    }

    public static void showKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }

        InputMethodManager inputManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        View focusedView = activity.getCurrentFocus();

        if (focusedView != null) {
            inputManager.showSoftInput(focusedView, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static void hideKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }

        InputMethodManager inputManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        View focusedView = activity.getCurrentFocus();

        // If focusedView is null then we will get NPE
        // http://stackoverflow.com/questions/19069448/null-pointer-error-with-hidesoftinputfromwindow
        if (focusedView != null) {
            inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }



}
