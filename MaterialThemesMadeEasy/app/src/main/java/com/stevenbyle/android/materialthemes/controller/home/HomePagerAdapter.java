package com.stevenbyle.android.materialthemes.controller.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.home.MaterialByXmlFragment.ThemingMethod;

import java.lang.ref.WeakReference;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the
 * sections/tabs/pages.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private WeakReference<Context> mContextRef;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContextRef = new WeakReference<Context>(context);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return MaterialByXmlFragment.newInstance(ThemingMethod.XML);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Context context = mContextRef.get();
        if (context != null) {
            switch (position) {
                case 0:
                    return context.getString(R.string.home_tab_xml);
                case 1:
                    return context.getString(R.string.home_tab_code);
            }
        }
        return null;
    }
}
