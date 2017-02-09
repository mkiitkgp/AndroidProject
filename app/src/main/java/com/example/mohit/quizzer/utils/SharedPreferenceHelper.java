package com.example.mohit.quizzer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mohit.quizzer.activities.QZApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mohit on 08/02/17.
 */

public class SharedPreferenceHelper {

    public static final String QZ_SHARED_PREF_NAME = "com.example.mohit.quizzer";
    public static final String KEY_APP_INTRO_FLOW = "KEY_APP_INTRO_FLOW";
    public static final String KEY_SIGNIN_STATUS = "KEY_SIGNIN_STATUS";


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static void openSharedPreferencesInEditMode() {
        editor = QZApplication.getContext().getSharedPreferences(QZ_SHARED_PREF_NAME, Context.MODE_PRIVATE).edit();
    }

    private static void openSharedPreferencesInReadMode() {
        sharedPreferences = QZApplication.getContext().
                getSharedPreferences(QZ_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    //    apply is fast than Commit
    private static void closeSharedPreferences() {
        editor.apply();
    }

    public static void set(String key, String value) {
        openSharedPreferencesInEditMode();
        editor.putString(key, value);
        closeSharedPreferences();
    }

    public static String getString(String key) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getString(key, "");
    }

    public static String getString(String key, String defaultValue) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getString(key, defaultValue);
    }

    public static boolean contains(String key) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.contains(key);
    }

    public static void set(String key, int value) {
        openSharedPreferencesInEditMode();
        editor.putInt(key, value);
        closeSharedPreferences();
    }

    public static void set(String key, long value) {
        openSharedPreferencesInEditMode();
        editor.putLong(key, value);
        closeSharedPreferences();
    }

    public static int getInt(String key) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getInt(key, 0);
    }

    public static int getInt(String key, int defaultValue) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getInt(key, defaultValue);
    }

    public static long getLong(String key, long defaultValue) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static void set(String key, boolean value) {
        openSharedPreferencesInEditMode();
        editor.putBoolean(key, value);
        closeSharedPreferences();
    }

    public static boolean getBoolean(String key) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getBoolean(key, false);
    }

    public static List<String> getAllKeys() {
        openSharedPreferencesInReadMode();
        List<String> sharedPreferenceKeys = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            sharedPreferenceKeys.add(entry.getKey());
        }
        return sharedPreferenceKeys;
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        openSharedPreferencesInReadMode();
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void deleteSharedPreference(String key) {
        openSharedPreferencesInEditMode();
        editor.remove(key);
        closeSharedPreferences();
    }

    public static void clearSharedPreferencesData() {
        openSharedPreferencesInEditMode();
        editor.clear();
        closeSharedPreferences();
    }


}
