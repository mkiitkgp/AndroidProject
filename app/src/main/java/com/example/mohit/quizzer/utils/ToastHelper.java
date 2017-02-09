package com.example.mohit.quizzer.utils;

import android.os.Looper;
import android.widget.Toast;

import com.example.mohit.quizzer.activities.QZApplication;

/**
 * Created by mohit on 09/02/17.
 */

public class ToastHelper {

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    public static void showToast(int stringResource) {
        showToast(QZApplication.getContext().getResources().getString(stringResource));
    }

    public static void showToast(String message, final int duration) {
        Toast.makeText(QZApplication.getContext(), message, duration).show();
    }

}
