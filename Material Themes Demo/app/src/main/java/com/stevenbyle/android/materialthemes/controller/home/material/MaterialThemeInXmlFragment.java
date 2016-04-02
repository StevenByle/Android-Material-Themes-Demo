package com.stevenbyle.android.materialthemes.controller.home.material;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.log.LogUtils;

/**
 * Fragment showing user interface elements that can be themed using XML in layout files.
 *
 * @author Steven Byle
 */
public class MaterialThemeInXmlFragment extends Fragment {
    private static final String TAG = LogUtils.generateTag(MaterialThemeInXmlFragment.class);

    public static MaterialThemeInXmlFragment newInstance() {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "newInstance");
        }

        // Create a new fragment instance
        MaterialThemeInXmlFragment fragment = new MaterialThemeInXmlFragment();

        // Get arguments passed in, if any
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }

        // Add parameters to the argument bundle
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnAttach(TAG);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreate(TAG, savedInstanceState);
        }

        // Get passed in parameters
        Bundle args = getArguments();

        // If no parameters were passed in, default them
        if (args == null) {
        }
        // Otherwise, set incoming parameters
        else {
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
            LogUtils.logOnCreateView(TAG, savedInstanceState);
        }

        // Inflate the fragment layout into the container
        View fragmentView = inflater.inflate(R.layout.fragment_material_theme_in_xml, container, false);

        // Reference views
        Spinner currentThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_current_theme);
        Spinner greenThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_green_theme);
        Spinner blueThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_blue_theme);

        // Set and bind data to views
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(
                container.getContext(),
                R.array.spinner_items_array,
                android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        currentThemeSpinner.setAdapter(spinnerArrayAdapter);
        greenThemeSpinner.setAdapter(spinnerArrayAdapter);
        blueThemeSpinner.setAdapter(spinnerArrayAdapter);

        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnViewCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnActivityCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnViewStateRestored(TAG, savedInstanceState);
        }
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
    public void onDestroyView() {
        super.onDestroyView();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnDestroyView(TAG);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnDestroy(TAG);
        }
    }
}
