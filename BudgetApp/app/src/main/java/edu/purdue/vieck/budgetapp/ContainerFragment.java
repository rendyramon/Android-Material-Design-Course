package edu.purdue.vieck.budgetapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vieck on 7/24/15.
 */
public class ContainerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_container, container, false);
        //FragmentManager fm = getChildFragmentManager();
        //FragmentTransaction ft = fm.beginTransaction();
        //ft.add(R.id.container, new ChartFragment(), "ChartFragment");
        //ft.commit();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
