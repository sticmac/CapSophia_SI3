package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fr.unice.polytech.si3.ihm.capsophia.fragment.EventsFragment;
import fr.unice.polytech.si3.ihm.capsophia.fragment.PlaceholderFragment;
import fr.unice.polytech.si3.ihm.capsophia.fragment.ShopsFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return new ShopsFragment();
            case 1:
                return new EventsFragment();
            default:
                return PlaceholderFragment.newInstance(position+1);
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Magasins";
            case 1:
                return "Événements";
            case 2:
                return "Trafic";
        }
        return null;
    }
}
