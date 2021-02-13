package com.org.calculator.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.org.calculator.R;
import com.org.calculator.view.fragment.MainFragment;
import com.org.calculator.view.fragment.ShowResultsFragment;

public class MainActivity extends SingleFragmentActivity
        implements MainFragment.MainFragmentCallback {

    public static final String MAIN_FRAGMENT_TAG = "MainFragmentTag";

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getFragment() {
        getSupportFragmentManager().
                beginTransaction().
                add(MainFragment.newInstance(),MAIN_FRAGMENT_TAG);
        return MainFragment.newInstance();
    }

    @Override
    public void onListBtnClickListener() {
        getSupportFragmentManager().
                beginTransaction().
                addToBackStack(MAIN_FRAGMENT_TAG).
                replace(R.id.fragment_container, ShowResultsFragment.newInstance()).
                commit();
    }
}