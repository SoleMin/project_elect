package org.techtown.project_elect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InfoFragment extends Fragment implements View.OnClickListener{


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View fv = inflater.inflate(R.layout.fragment_info, container, false);

            Button one, two;
            one = (Button) fv.findViewById(R.id.sel1);
            one.setOnClickListener(this);
            two = (Button) fv.findViewById(R.id.sel2);
            two.setOnClickListener(this);

            return fv;
        }

        @Override
        public void onClick(View view) {

            Fragment fg;
            switch (view.getId()) {
                case R.id.sel1:
                    fg = new MajorFragment();
                    setChildFragment(fg);
                    break;
                case R.id.sel2:
                    fg = MapFragment.newInstance(37.868320,127.738777,"test","asd");
                    setChildFragment(fg);
                    break;
            }
        }

        private void setChildFragment(Fragment child) {
            FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

            if (!child.isAdded()) {
                childFt.replace(R.id.child_fragment_container, child);
                childFt.addToBackStack(null);
                childFt.commit();
            }
        }
}