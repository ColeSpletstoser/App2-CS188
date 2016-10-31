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

    private ImageView dogImageView;
    private TextView nameTextView;
    private Button passButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.home_fragment, container, false);

        dogImageView = (ImageView) layout.findViewById(R.id.dogImageView);
        nameTextView = (TextView) layout.findViewById(R.id.nameTextView);
        passButton = (Button) layout.findViewById(R.id.passButton);

        final Profile profile1 = new Profile("Bone", "Lab", 'M', "Super cute. Good with other dogs.", R.drawable.shiba, "Joe", "I'm a cool person", R.drawable.profileimage, 42.1, 94.2);
        final Profile profile2 = new Profile ("Barker", "Yorkie", 'F', "Terrible dog.", R.drawable.profileimage, "Dave", "Hi! I'm all right.", R.drawable.shiba, 42.1, 94.1);

        final Profile[] profiles = {profile1, profile2};

        passButton.setText("Start!");

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                passButton.setText("Pass");

                double[] phoneLocation = ((HomePage) getActivity()).userLocation;
                nameTextView.append(" " + phoneLocation[0]);
                nameTextView.append(" " + phoneLocation[1]);

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
                    nameTextView.setText("No more profiles near you");
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
