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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.dialog.DialogUtils;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialThemeUtils;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = LogUtils.generateTag(HomeActivity.class);

    private static final String KEY_ARG_CURRENT_THEME = "KEY_ARG_CURRENT_THEME";

    private MaterialTheme mCurrentTheme;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HomePagerAdapter mViewPagerAdapter;

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
            mCurrentTheme = MaterialThemeUtils.getThemeList().get(0);
        }
        // Otherwise, set incoming parameters
        else {
            mCurrentTheme = (MaterialTheme) args.getSerializable(KEY_ARG_CURRENT_THEME);
        }

        // Set the theme before calling super or setContentView
        setTheme(mCurrentTheme.getThemeResId());
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreate(TAG, savedInstanceState);
        }

        // Set the content view to a layout and reference views
        setContentView(R.layout.activity_home);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state variables
        else {
        }

        // Set and bind data to views
        setSupportActionBar(mToolbar);

        mViewPagerAdapter = new HomePagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        // TODO
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = SetThemeDialogFragment.newInstance(mCurrentTheme);
                DialogUtils.showDialogFragment(getSupportFragmentManager(), dialogFragment);
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onCreateOptionsMenu");
        }

        // Inflate the menu items to the toolbar
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onOptionsItemSelected");
        }

        // TODO

        return super.onOptionsItemSelected(item);
    }

}
