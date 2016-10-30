package cs188.doggydate;

import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by Spletz on 10/20/16.
 */
public class HomeFragment extends Fragment {

    private Profile currProfile;
    private int index = 0;

    private ImageButton dogImageButton;
    private TextView nameTextView;
    private Button passButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.home_fragment, container, false);

        dogImageButton = (ImageButton) layout.findViewById(R.id.dogImageButton);
        nameTextView = (TextView) layout.findViewById(R.id.nameTextView);
        passButton = (Button) layout.findViewById(R.id.passButton);

        final Profile profile1 = new Profile("Bone", "Lab", 'M', "Super cute. Good with other dogs.", R.drawable.shiba, "Joe", "I'm a cool person", R.drawable.profileimage);
        final Profile profile2 = new Profile ("Barker", "Yorkie", 'F', "Terrible dog.", R.drawable.profileimage, "Dave", "Hi! I'm all right.", R.drawable.shiba);

        final Profile[] profiles = {profile1, profile2};


        currProfile = profiles[index];
        nameTextView.setText(profile1.getDogName());
        dogImageButton.setImageResource(currProfile.getDogPicture());


        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index + 1;
                currProfile = profiles[index];
                nameTextView.setText(currProfile.getDogName());
                dogImageButton.setImageResource(currProfile.getDogPicture());
            }
        });

        dogImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("Profile", currProfile);
                startActivity(intent);
            }
        });

//        double[] phoneLocation = ((HomePage) getActivity()).userLocation;
//        nameTextView.append(" " + phoneLocation[0]);
//        nameTextView.append(" " + phoneLocation[1]);

        return layout;
    }
}
