package com.stevenbyle.android.materialthemes.controller.home.material;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.global.DialogUtils;
import com.stevenbyle.android.materialthemes.global.LogUtils;
import com.stevenbyle.android.materialthemes.global.LogUtils.LogLevel;

/**
 * TODO
 */
public class MaterialThemeInXmlFragment extends Fragment implements OnClickListener {
    private static final String TAG = LogUtils.generateTag(MaterialThemeInXmlFragment.class);

    private Button mCurrentThemeDialogButton, mGreenThemeDialogButton, mBlueThemeDialogButton;
    private Button mCurrentThemeSnackbarButton, mGreenThemeSnackbarButton, mBlueThemeSnackbarButton;
    private Spinner mCurrentThemeSpinner, mGreenThemeSpinner, mBlueThemeSpinner;

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
        mCurrentThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_current_theme);
        mGreenThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_green_theme);
        mBlueThemeSpinner = (Spinner) fragmentView.findViewById(R.id.fragment_material_theme_spinner_blue_theme);
        mCurrentThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_current_theme);
        mGreenThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_green_theme);
        mBlueThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_blue_theme);
        mCurrentThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_current_theme);
        mGreenThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_green_theme);
        mBlueThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_blue_theme);

        // Set and bind data to views
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(
                container.getContext(),
                R.array.spinner_theme_options_array,
                android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mCurrentThemeSpinner.setAdapter(spinnerArrayAdapter);
        mGreenThemeSpinner.setAdapter(spinnerArrayAdapter);
        mBlueThemeSpinner.setAdapter(spinnerArrayAdapter);

        mCurrentThemeDialogButton.setOnClickListener(this);
        mGreenThemeDialogButton.setOnClickListener(this);
        mBlueThemeDialogButton.setOnClickListener(this);
        mCurrentThemeSnackbarButton.setOnClickListener(this);
        mGreenThemeSnackbarButton.setOnClickListener(this);
        mBlueThemeSnackbarButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onClick");
        }

        switch (v.getId()) {
            case R.id.fragment_material_theme_button_dialog_current_theme:
                MaterialThemeDialogFragment dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_current_theme,
                        R.string.material_theme_current_theme);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_dialog_green_theme:
                dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_green_theme,
                        R.string.material_theme_green_theme);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_dialog_blue_theme:
                dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_blue_theme,
                        R.string.material_theme_blue_theme);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_snackbar_current_theme:
                Snackbar.make(v, R.string.material_theme_current_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.material_theme_current_theme, this)
                        .show();
                break;

            case R.id.fragment_material_theme_button_snackbar_green_theme:
                //FIXME
                View v2 = new View(new ContextThemeWrapper(v.getContext(), R.style.AppTheme_Green), null, 0);
                Snackbar.make(v2, R.string.material_theme_green_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.material_theme_green_theme, this)
                        .show();
                break;

            case R.id.fragment_material_theme_button_snackbar_blue_theme:
                Snackbar.make(v, R.string.material_theme_blue_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.material_theme_blue_theme, this)
                        .show();
                break;

            default:
                if (BuildConfig.DEBUG) {
                    LogUtils.logMessage(LogLevel.WARN, TAG, "onClick", "unknown view clicked");
                }
                break;
        }

    }
}
