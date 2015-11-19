package com.stevenbyle.android.materialthemes.controller.global;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.home.material.MaterialTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Byle
 */
public class ThemeUtils {

    private static List<MaterialTheme> sThemeList;

    public static List<MaterialTheme> getThemeList() {
        if (sThemeList == null) {
            sThemeList = new ArrayList<MaterialTheme>();
            sThemeList.add(new MaterialTheme(R.string.set_theme_dialog_option_orange, R.style.AppTheme_Orange));
            sThemeList.add(new MaterialTheme(R.string.set_theme_dialog_option_green, R.style.AppTheme_Green));
            sThemeList.add(new MaterialTheme(R.string.set_theme_dialog_option_blue, R.style.AppTheme_Blue));
        }

        return sThemeList;
    }
}
