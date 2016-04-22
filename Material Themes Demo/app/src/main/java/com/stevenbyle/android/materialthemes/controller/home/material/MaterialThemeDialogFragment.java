package com.stevenbyle.android.materialthemes.controller.home.material;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;

import timber.log.Timber;

/**
 * Simple dialog fragment that creates an alert dialog that can be themed.
 *
 * @author Steven Byle
 */
public class MaterialThemeDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    private static final String KEY_ARG_TITLE = "KEY_ARG_TITLE";
    private static final String KEY_ARG_MESSAGE = "KEY_ARG_MESSAGE";
    private static final String KEY_ARG_ALERT_DIALOG_THEME = "KEY_ARG_ALERT_DIALOG_THEME";

    private String mTitle, mMessage;
    private MaterialTheme mAlertDialogTheme;

    public static MaterialThemeDialogFragment newInstance(String title, String message,
            @Nullable MaterialTheme alertDialogTheme) {
        Timber.v(LogUtils.METHOD_ONLY);

        MaterialThemeDialogFragment fragment = new MaterialThemeDialogFragment();
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(KEY_ARG_TITLE, title);
        args.putString(KEY_ARG_MESSAGE, message);
        args.putSerializable(KEY_ARG_ALERT_DIALOG_THEME, alertDialogTheme);
        fragment.setArguments(args);

        return fragment;
    }

    public static MaterialThemeDialogFragment newInstance(Context context, @StringRes int titleResId,
            @StringRes int messageResId, @Nullable MaterialTheme alertDialogTheme) {

        MaterialThemeDialogFragment fragment = newInstance(
                context.getString(titleResId),
                context.getString(messageResId),
                alertDialogTheme);
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
            mTitle = null;
            mMessage = null;
            mAlertDialogTheme = null;
        }
        // Otherwise, set incoming parameters
        else {
            mTitle = args.getString(KEY_ARG_TITLE);
            mMessage = args.getString(KEY_ARG_MESSAGE);
            mAlertDialogTheme = (MaterialTheme) args.getSerializable(KEY_ARG_ALERT_DIALOG_THEME);
        }

        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state
        else {
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));

        // Create the alert dialog using the proper theme
        Activity parentActivity = getActivity();
        AlertDialog.Builder alertDialogBuilder;
        if (mAlertDialogTheme != null) {
            alertDialogBuilder = new AlertDialog.Builder(parentActivity, mAlertDialogTheme.getThemeResId());
        } else {
            alertDialogBuilder = new AlertDialog.Builder(parentActivity);
        }

        alertDialogBuilder.setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(R.string.material_theme_dialog_button_positive, this)
                .setNegativeButton(R.string.material_theme_dialog_button_negative, this);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        return alertDialog;
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
    }
}