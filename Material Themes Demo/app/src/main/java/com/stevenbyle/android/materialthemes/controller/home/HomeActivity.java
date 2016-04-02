package com.stevenbyle.android.materialthemes.controller.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.dialog.DialogUtils;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;
import com.stevenbyle.android.materialthemes.log.LogUtils.LogLevel;

/**
 * Home activity which holds the app bar (toolbar + tab layout) and a view pager with the themed
 * fragments.
 *
 * @author Steven Byle
 */
public class HomeActivity extends AppCompatActivity implements OnClickListener {
    private static final String TAG = LogUtils.generateTag(HomeActivity.class);

    private static final String KEY_ARG_CURRENT_THEME = "KEY_ARG_CURRENT_THEME";

    private MaterialTheme mCurrentTheme;

    public static Intent newInstanceIntent(Context context, MaterialTheme currentTheme) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "newInstanceIntent");
        }

        // Create an intent that will start the activity
        Intent intent = new Intent(context, HomeActivity.class);

        // Get arguments passed in, if any
        Bundle args = intent.getExtras();
        if (args == null) {
            args = new Bundle();
        }

        // Add parameters to the argument bundle
        args.putSerializable(KEY_ARG_CURRENT_THEME, currentTheme);
        intent.putExtras(args);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Get passed in parameters
        Bundle args = getIntent().getExtras();

        // If no parameters were passed in, default them
        if (args == null) {
            mCurrentTheme = null;
        }
        // Otherwise, set incoming parameters
        else {
            mCurrentTheme = (MaterialTheme) args.getSerializable(KEY_ARG_CURRENT_THEME);
        }

        // If not set, default the theme
        if (mCurrentTheme == null) {
            mCurrentTheme = MaterialTheme.THEME_TEAL;
        }

        // Theme must be set before calling super or setContentView
        setTheme(mCurrentTheme.getThemeResId());

        // Handle super calls after setting the theme
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreate(TAG, savedInstanceState);
        }

        // Set the content view to a layout and reference views
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_home_toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_home_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_home_tab_layout);

        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state variables
        else {
        }

        // Set and bind data to views
        setSupportActionBar(toolbar);

        HomePagerAdapter viewPagerAdapter = new HomePagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.activity_home_fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            LogUtils.logOnStart(TAG);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            LogUtils.logOnResume(TAG);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) {
            LogUtils.logOnPause(TAG);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (BuildConfig.DEBUG) {
            LogUtils.logOnSaveInstanceState(TAG);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) {
            LogUtils.logOnStop(TAG);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            LogUtils.logOnDestroy(TAG);
        }
    }

    @Override
    public void onClick(View v) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onClick");
        }

        switch (v.getId()) {
            case R.id.activity_home_fab:
                DialogFragment dialogFragment = SetThemeDialogFragment.newInstance(mCurrentTheme);
                DialogUtils.showDialogFragment(getSupportFragmentManager(), dialogFragment);
                break;
            default:
                if (BuildConfig.DEBUG) {
                    LogUtils.logMessage(LogLevel.WARN, TAG, "onClick", "unknown view clicked");
                }
                break;
        }
    }
}
