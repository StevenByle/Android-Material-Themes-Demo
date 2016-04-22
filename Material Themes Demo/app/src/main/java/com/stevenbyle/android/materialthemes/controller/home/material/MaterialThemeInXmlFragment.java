package com.stevenbyle.android.materialthemes.controller.home.material;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.log.LogUtils;

import timber.log.Timber;

/**
 * Fragment showing user interface elements that can be themed using XML in layout files.
 *
 * @author Steven Byle
 */
public class MaterialThemeInXmlFragment extends Fragment {

    public static MaterialThemeInXmlFragment newInstance() {
        Timber.v(LogUtils.METHOD_ONLY);

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
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.v(LogUtils.METHOD_ONLY);

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
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));

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
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));
    }

    @Override
    public void onStart() {
        super.onStart();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.v(LogUtils.METHOD_ONLY);
    }
}
