package com.org.calculator.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.org.calculator.view.fragment.MainFragment;

public class MainActivity extends SingleFragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}