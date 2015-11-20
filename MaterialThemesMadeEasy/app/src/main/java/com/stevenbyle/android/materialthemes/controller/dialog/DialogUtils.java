package com.stevenbyle.android.materialthemes.controller.dialog;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * @author Steven Byle
 */
public class DialogUtils {

    public static String showDialogFragment(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        return showDialogFragment(fragmentManager, dialogFragment, generateFragmentTag(dialogFragment));
    }

    public static String showDialogFragment(FragmentManager fragmentManager, DialogFragment dialogFragment,
            String fragmentTag) {
        return showDialogFragment(fragmentManager, dialogFragment, fragmentTag, true);
    }

    public static String showDialogFragment(FragmentManager fragmentManager, DialogFragment dialogFragment,
            boolean onlyIfNotDuplicate) {
        return showDialogFragment(fragmentManager, dialogFragment, generateFragmentTag(dialogFragment), onlyIfNotDuplicate);
    }

    public static String showDialogFragment(FragmentManager fragmentManager, DialogFragment dialogFragment,
            String fragmentTag, boolean onlyIfNotDuplicate) {

        // If only showing non duplicates dialogs, make sure the fragment isn't already in the manager
        boolean doesFragmentExist = fragmentManager.findFragmentByTag(fragmentTag) != null;
        if (!(onlyIfNotDuplicate && doesFragmentExist)) {
            dialogFragment.show(fragmentManager, fragmentTag);
        }

        return fragmentTag;
    }

    private static String generateFragmentTag(Fragment fragment) {
        return fragment.getClass().getName();
    }

}
