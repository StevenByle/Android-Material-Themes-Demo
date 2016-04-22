package com.stevenbyle.android.materialthemes.controller.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Dialog fragment used to select a new theme. Upon selection, this starts a new home activity and
 * clears the task stack.
 *
 * @author Steven Byle
 */
public class SetThemeDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    private static final String KEY_ARG_CURRENT_THEME = "KEY_ARG_CURRENT_THEME";

    private MaterialTheme mCurrentTheme;
    private int mCurrentSelectedThemeIndex;
    private SingleChoiceOnClickListener mSingleChoiceOnClickListener;

    public static SetThemeDialogFragment newInstance(MaterialTheme currentTheme) {
        Timber.v(LogUtils.METHOD_ONLY);

        SetThemeDialogFragment fragment = new SetThemeDialogFragment();
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putSerializable(KEY_ARG_CURRENT_THEME, currentTheme);
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
            mCurrentTheme = null;
        }
        // Otherwise, set incoming parameters
        else {
            mCurrentTheme = (MaterialTheme) args.getSerializable(KEY_ARG_CURRENT_THEME);
        }

        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state
        else {
        }

        mSingleChoiceOnClickListener = new SingleChoiceOnClickListener();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));

        List<String> themeNameList = new ArrayList<String>();
        for (MaterialTheme materialTheme : MaterialTheme.getThemeList()) {
            themeNameList.add(getString(materialTheme.getNameResId()));
        }

        mCurrentSelectedThemeIndex = MaterialTheme.getThemeList().indexOf(mCurrentTheme);
        String[] themeNameArray = themeNameList.toArray(new String[themeNameList.size()]);

        Activity parentActivity = getActivity();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(parentActivity)
                .setTitle(R.string.set_theme_dialog_title)
                .setNegativeButton(R.string.set_theme_dialog_button_negative, this)
                .setSingleChoiceItems(themeNameArray, mCurrentSelectedThemeIndex, mSingleChoiceOnClickListener);

        Dialog dialog = alertDialogBuilder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = super.onCreateView(inflater, container, savedInstanceState);
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));
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
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Timber.d(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Timber.d(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Timber.d(LogUtils.METHOD_ONLY);

        switch (which) {
            case DialogInterface.BUTTON_NEGATIVE:
                // Just let the dialog dismiss
                break;
        }
    }

    private class SingleChoiceOnClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // Upon selection, figure out which theme was selected
            mCurrentSelectedThemeIndex = which;
            MaterialTheme newTheme = MaterialTheme.getThemeList().get(mCurrentSelectedThemeIndex);

            // If the theme is new, set it and start a new activity
            if (!mCurrentTheme.equals(newTheme)) {
                Activity parentActivity = getActivity();
                Intent intent = HomeActivity.newInstanceIntent(parentActivity, newTheme);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                parentActivity.startActivity(intent);
            }
        }
    }
}