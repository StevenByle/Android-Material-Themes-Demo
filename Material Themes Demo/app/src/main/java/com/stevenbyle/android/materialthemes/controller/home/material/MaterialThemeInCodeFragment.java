package com.stevenbyle.android.materialthemes.controller.home.material;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.dialog.DialogUtils;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;

import timber.log.Timber;

/**
 * Fragment showing user interface elements that can be themed using code at runtime.
 *
 * @author Steven Byle
 */
public class MaterialThemeInCodeFragment extends Fragment implements OnClickListener {

    public static MaterialThemeInCodeFragment newInstance() {
        Timber.v(LogUtils.METHOD_ONLY);

        // Create a new fragment instance
        MaterialThemeInCodeFragment fragment = new MaterialThemeInCodeFragment();

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
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));

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
        View fragmentView = inflater.inflate(R.layout.fragment_material_theme_in_code, container, false);

        // Reference views
        Button currentThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_current_theme);
        Button greenThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_green_theme);
        Button blueThemeDialogButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_dialog_blue_theme);
        Button currentThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_current_theme);
        Button greenThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_green_theme);
        Button blueThemeSnackbarButton = (Button) fragmentView.findViewById(R.id.fragment_material_theme_button_snackbar_blue_theme);

        // Set and bind data to views
        currentThemeDialogButton.setOnClickListener(this);
        greenThemeDialogButton.setOnClickListener(this);
        blueThemeDialogButton.setOnClickListener(this);
        currentThemeSnackbarButton.setOnClickListener(this);
        greenThemeSnackbarButton.setOnClickListener(this);
        blueThemeSnackbarButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        Timber.d(LogUtils.METHOD_ONLY);

        switch (v.getId()) {
            case R.id.fragment_material_theme_button_dialog_current_theme:
                MaterialThemeDialogFragment dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_current_theme,
                        R.string.material_theme_current_theme,
                        null);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_dialog_green_theme:
                dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_green_theme,
                        R.string.material_theme_green_theme,
                        MaterialTheme.THEME_ALERT_DIALOG_GREEN);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_dialog_blue_theme:
                dialogFragment = MaterialThemeDialogFragment.newInstance(v.getContext(),
                        R.string.material_theme_blue_theme,
                        R.string.material_theme_blue_theme,
                        MaterialTheme.THEME_ALERT_DIALOG_BLUE);

                DialogUtils.showDialogFragment(getChildFragmentManager(), dialogFragment);
                break;

            case R.id.fragment_material_theme_button_snackbar_current_theme:
                Snackbar.make(v, R.string.material_theme_current_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.snackbar_action, this)
                        .show();
                break;

            case R.id.fragment_material_theme_button_snackbar_green_theme:
                Theme greenTheme = new ContextThemeWrapper(v.getContext(), R.style.AppTheme_Green).getTheme();
                TypedArray a = greenTheme.obtainStyledAttributes(new int[] {R.attr.colorAccent});
                int accentColor = a.getColor(0, 0);
                a.recycle();

                Snackbar.make(v, R.string.material_theme_green_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.snackbar_action, this)
                        .setActionTextColor(accentColor)
                        .show();
                break;

            case R.id.fragment_material_theme_button_snackbar_blue_theme:
                Theme blueTheme = new ContextThemeWrapper(v.getContext(), R.style.AppTheme_Blue).getTheme();
                a = blueTheme.obtainStyledAttributes(new int[] {R.attr.colorAccent});
                accentColor = a.getColor(0, 0);
                a.recycle();

                Snackbar.make(v, R.string.material_theme_blue_theme, Snackbar.LENGTH_LONG)
                        .setAction(R.string.snackbar_action, this)
                        .setActionTextColor(accentColor)
                        .show();
                break;

            default:
                Timber.w("Unknown view clicked");
                break;
        }
    }
}
