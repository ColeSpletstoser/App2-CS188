package cs188.doggydate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;
import static android.app.Activity.RESULT_OK;
import static cs188.doggydate.R.layout.activity_home_page;
import static cs188.doggydate.R.layout.home_fragment;
import static cs188.doggydate.R.layout.profile_fragment;

/**
 * Created by Spletz on 10/20/16.
 * edited by True 10/22/16
 * written entirely by True
 *
 * Important: the profile won't update after being edited in PreferencesActivity until you switch pages in the viewPager.
 * Also - it won't display anything in the fields until you click the settings button.
 * This is an unfortunate result of mismashed/unfinished code and I could not figure out how to fix it.
 */


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(profile_fragment, container, false);


        //initializes all the elements of profile_fragment.xml into variables
        ImageButton btn1 = (ImageButton) view.findViewById(R.id.settingsButton);

        TextView dogInfo = (TextView) view.findViewById(R.id.dogInfo);

        TextView dogBree = (TextView) view.findViewById(R.id.dogBreed);
        TextView dogDesc = (TextView) view.findViewById(R.id.dogDescription);
        TextView dogGen = (TextView) view.findViewById(R.id.dogGender);

        TextView ownInfo = (TextView) view.findViewById(R.id.ownerName);
        TextView ownDesc = (TextView) view.findViewById(R.id.ownerDescription);


        //opens up sharedpreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        //gets all of the strings from the preferences

        String dogname = preferences.getString("dog_name", "");
        String dogbreed = preferences.getString("dog_breed", "");
        String dogage = preferences.getString("dog_age", "");
        String dogDescription = preferences.getString("dog_description", "");
        String dogGender = preferences.getString("dog_gender", "");

        String ownName = preferences.getString("owner_name", "");
        String ownDescrip = preferences.getString("owner_description", "");


        //makes it so the text views in the profile fragment mirror what's in the user's settings

        dogInfo.setText(dogname + ", " + dogage);
        dogDesc.setText(dogDescription);
        dogBree.setText(dogbreed);
        dogGen.setText(dogGender);

        ownInfo.setText(ownName);
        ownDesc.setText(ownDescrip);


        //button for the settings stuff
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PreferencesActivity.class);
                startActivity(intent);

            }
        });

        //there are supposed to be buttons here where the user can upload and change pictures of themselves and their dogs
        //but Kelly did not finish that functionality, and we had delegated that task to her
        //hence why there are buttons that don't do anything at the bottom of the screen

        return view;}
    }



