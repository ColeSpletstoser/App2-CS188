package cs188.doggydate;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.Serializable;

/**
 * Created by Spletz on 10/20/16.
 */
public class HomeFragment extends Fragment {

    private Profile currProfile;
    private int index = -1;
    private double[] phoneLocation = {0, 0};

    private ImageView dogImageView;
    private TextView nameTextView;
    private Button passButton;
    private Button inviteButton;
    private Button locationButton;
    private TextView promptTextView;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.home_fragment, container, false);

        dogImageView = (ImageView) layout.findViewById(R.id.dogImageView);
        nameTextView = (TextView) layout.findViewById(R.id.nameTextView);
        passButton = (Button) layout.findViewById(R.id.passButton);
        inviteButton = (Button) layout.findViewById(R.id.inviteButton);
        locationButton = (Button) layout.findViewById(R.id.locationButton);
        promptTextView = (TextView) layout.findViewById(R.id.promptTextView);

        dogImageView.setVisibility(View.GONE);
        nameTextView.setVisibility(View.GONE);
        passButton.setVisibility(View.GONE);
        inviteButton.setVisibility(View.GONE);


        final Profile profile1 = new Profile("Bone", "Lab", 'M', "Super cute. Good with other dogs.", R.drawable.dog1, "Joe", "I'm a cool person", R.drawable.person1, 41.64, -93.47);
        final Profile profile2 = new Profile ("Barker", "Yorkie", 'F', "Terrible dog.", R.drawable.dog2, "Dave", "Hi! I'm all right.", R.drawable.person2, 41.645, -93.475);
        final Profile profile3 = new Profile ("Lexie", "Mutt", 'F', "My best friend! Doesn't play the best with kids, but gets along with anyone else.", R.drawable.dog3, "Billy", "Because anything worth doing is uncomfortable.", R.drawable.person3, 41.65, -93.48);
        final Profile profile4 = new Profile ("Bartholomew", "Mutt", 'M', "Stellar with literally anyone, needs the fresh air.", R.drawable.dog4, "Jim", "You miss 100% of the shots you don't take.", R.drawable.person4, 41.65, -93.473);
        final Profile profile5 = new Profile ("Mister Bear", "Purebred", 'M', "Hopefully he'll find a friend. He's shy, but opens up eventually.", R.drawable.dog5, "Seth", "What's up? Let's meet each other's dogs!", R.drawable.person5, 41.638, -93.47);

        final Profile[] profiles = {profile1, profile2, profile3, profile4, profile5};

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneLocation = ((HomePage) getActivity()).userLocation;

                locationButton.setVisibility(View.GONE);
                promptTextView.setVisibility(View.GONE);

                dogImageView.setVisibility(View.VISIBLE);
                nameTextView.setVisibility(View.VISIBLE);
                passButton.setVisibility(View.VISIBLE);
                inviteButton.setVisibility(View.VISIBLE);

                int dist = 26;
                index = index + 1;

                try{
                    while (dist > 25){
                        currProfile = profiles[index];
                        dist = calculateDistance(phoneLocation[0], phoneLocation[1], currProfile.getLatitude(), currProfile.getLongitute());
                        if (dist >= 25) { // checks if the profile is within 25 miles or else moves on to the next one
                            index = index + 1;
                        }
                    }

                    nameTextView.setText(currProfile.getDogName());
                    dogImageView.setImageResource(currProfile.getDogPicture());
                }
                catch(Exception e){

                    dogImageView.setVisibility(View.GONE);
                    nameTextView.setVisibility(View.GONE);
                    passButton.setVisibility(View.GONE);
                    inviteButton.setVisibility(View.GONE);

                    promptTextView.setVisibility(View.VISIBLE);

                    promptTextView.setText("No more puppies near you");
                }
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phoneLocation = ((HomePage) getActivity()).userLocation;

                int dist = 26;
                index = index + 1;

                try{
                    while (dist > 25){
                        currProfile = profiles[index];
                        dist = calculateDistance(phoneLocation[0], phoneLocation[1], currProfile.getLatitude(), currProfile.getLongitute());
                        if (dist >= 25) { // checks if the profile is within 25 miles or else moves on to the next one
                            index = index + 1;
                        }
                    }

                    nameTextView.setText(currProfile.getDogName());
                    dogImageView.setImageResource(currProfile.getDogPicture());
                }
                catch(Exception e){
                    dogImageView.setVisibility(View.GONE);
                    nameTextView.setVisibility(View.GONE);
                    passButton.setVisibility(View.GONE);
                    inviteButton.setVisibility(View.GONE);

                    promptTextView.setVisibility(View.VISIBLE);

                    promptTextView.setText("No more puppies near you");
                }
            }
        });

        dogImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (currProfile != null)
                {
                    Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                    intent.putExtra("Profile", currProfile);
                    startActivity(intent);
                }
            }
        });

        return layout;
    }

    public final static double AVERAGE_RADIUS_OF_EARTH = 6371;
    public int calculateDistance(double userLat, double userLng,
                                 double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round((AVERAGE_RADIUS_OF_EARTH * c)/1.60937));
    }
}
