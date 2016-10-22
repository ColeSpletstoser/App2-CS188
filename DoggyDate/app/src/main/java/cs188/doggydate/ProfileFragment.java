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
import android.widget.Toast;

/**
 * Created by Spletz on 10/20/16.
 * edited by True 10/22/16
 */


public class ProfileFragment extends Fragment implements View.OnClickListener {

    ImageButton btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        btn = (ImageButton) view.findViewById(R.id.settingsButton);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
//        Intent myIntent = new Intent(ProfileFragment.this, SettingsActivity.class);
//        //myIntent.putExtra("key", value); //Optional parameters
//        ProfileFragment.this.startActivity(myIntent);
   }
}