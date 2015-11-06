package com.stevenbyle.android.materialthemes.controller.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.global.LogUtil;
import com.stevenbyle.android.materialthemes.global.LogUtil.LogLevel;

/**
 * TODO
 */
public class MaterialThemeFragment extends Fragment {
    private static final String TAG = LogUtil.generateTag(MaterialThemeFragment.class);

    private static final String KEY_ARG_THEMING_METHOD = "KEY_ARG_THEMING_METHOD";

    private ThemingMethod mThemingMethod;

    public static MaterialThemeFragment newInstance(ThemingMethod themingMethod) {
        if (BuildConfig.DEBUG) {
            LogUtil.logMessage(LogLevel.DEBUG, TAG, "newInstance");
        }

        // Create a new fragment instance
        MaterialThemeFragment fragment = new MaterialThemeFragment();

        // Get arguments passed in, if any
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }

        // Add parameters to the argument bundle
        args.putSerializable(KEY_ARG_THEMING_METHOD, themingMethod);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnAttach(TAG);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnCreate(TAG, savedInstanceState);
        }

        // Get passed in parameters
        Bundle args = getArguments();

        // If no parameters were passed in, default them
        if (args == null) {
            mThemingMethod = null;
        }
        // Otherwise, set incoming parameters
        else {
            mThemingMethod = (ThemingMethod) args.getSerializable(KEY_ARG_THEMING_METHOD);
        }


        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state variables
        else {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (BuildConfig.DEBUG) {
            LogUtil.logOnCreateView(TAG, savedInstanceState);
        }

        // Inflate the fragment layout into the container
        View fragmentView = inflater.inflate(R.layout.fragment_theme_by_xml, container, false);

        // Reference views


        // Set and bind data to views


        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnViewCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnActivityCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnViewStateRestored(TAG, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnStart(TAG);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnResume(TAG);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnPause(TAG);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (BuildConfig.DEBUG) {
            LogUtil.logOnSaveInstanceState(TAG);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnStop(TAG);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnDestroyView(TAG);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (BuildConfig.DEBUG) {
            LogUtil.logOnDestroy(TAG);
        }
    }

    public enum ThemingMethod {
        XML, CODE
    }
}
