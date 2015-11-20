package com.stevenbyle.android.materialthemes.controller.home.material;

import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;

import java.io.Serializable;

/**
 * @author Steven Byle
 */
public class MaterialTheme implements Serializable {

    @StringRes
    private int nameResId;
    @StyleRes
    private int themeResId;

    public MaterialTheme(int nameResId, int themeResId) {
        this.nameResId = nameResId;
        this.themeResId = themeResId;
    }

    public int getNameResId() {
        return nameResId;
    }

    public int getThemeResId() {
        return themeResId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MaterialTheme that = (MaterialTheme) o;

        if (nameResId != that.nameResId) {
            return false;
        }
        return themeResId == that.themeResId;

    }

    @Override
    public int hashCode() {
        int result = nameResId;
        result = 31 * result + themeResId;
        return result;
    }
}
