package com.stevenbyle.android.materialthemes.controller.theme;

import com.stevenbyle.android.materialthemes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Byle
 */
public class MaterialThemeUtils {
    // App themes
    public static final MaterialTheme THEME_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.AppTheme_Orange);
    public static final MaterialTheme THEME_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.AppTheme_Green);
    public static final MaterialTheme THEME_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.AppTheme_Blue);

    // Dialog themes
    public static final MaterialTheme THEME_DIALOG_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.DialogTheme_Orange);
    public static final MaterialTheme THEME_DIALOG_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.DialogTheme_Green);
    public static final MaterialTheme THEME_DIALOG_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.DialogTheme_Blue);

    // Alert dialog themes
    public static final MaterialTheme THEME_ALERT_DIALOG_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.AlertDialogTheme_Orange);
    public static final MaterialTheme THEME_ALERT_DIALOG_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.AlertDialogTheme_Green);
    public static final MaterialTheme THEME_ALERT_DIALOG_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.AlertDialogTheme_Blue);

    private static List<MaterialTheme> sThemeList;
    private static List<MaterialTheme> sDialogThemeList;
    private static List<MaterialTheme> sAlertDialogThemeList;

    public static List<MaterialTheme> getThemeList() {
        if (sThemeList == null) {
            sThemeList = new ArrayList<MaterialTheme>();
            sThemeList.add(THEME_ORANGE);
            sThemeList.add(THEME_GREEN);
            sThemeList.add(THEME_BLUE);
        }

        return sThemeList;
    }

    public static List<MaterialTheme> getDialogThemeList() {
        if (sDialogThemeList == null) {
            sDialogThemeList = new ArrayList<MaterialTheme>();
            sDialogThemeList.add(THEME_DIALOG_ORANGE);
            sDialogThemeList.add(THEME_DIALOG_GREEN);
            sDialogThemeList.add(THEME_DIALOG_BLUE);
        }

        return sThemeList;
    }

    public static List<MaterialTheme> getAlertDialogThemeList() {
        if (sAlertDialogThemeList == null) {
            sAlertDialogThemeList = new ArrayList<MaterialTheme>();
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_ORANGE);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_GREEN);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_BLUE);
        }

        return sThemeList;
    }
}
