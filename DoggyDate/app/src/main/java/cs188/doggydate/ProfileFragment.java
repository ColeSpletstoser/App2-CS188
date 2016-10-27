package cs188.doggydate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static cs188.doggydate.R.layout.profile_fragment;

/**
 * Created by Spletz on 10/20/16.
 * edited by True 10/22/16
 */


public class ProfileFragment extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(profile_fragment, container, false);

        ImageButton btn1 = (ImageButton) view.findViewById(R.id.settingsButton);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PreferencesActivity.class);
                startActivity(intent);

            }
        });

        return view;}}