package cs188.doggydate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private TextView dogName;
    private TextView dogBreed;
    private TextView dogGender;
    private TextView dogDescription;
    private ImageView dogImage;
    private ImageView ownerImage;
    private TextView ownerName;
    private TextView ownerDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Profile profile = (Profile) getIntent().getSerializableExtra("Profile");

        dogName = (TextView) findViewById(R.id.dogName);
        dogBreed = (TextView) findViewById(R.id.dogBreed);
        dogGender = (TextView) findViewById(R.id.dogGender);
        dogDescription = (TextView) findViewById(R.id.dogDescription);
        dogImage = (ImageView) findViewById(R.id.dogImage);
        ownerImage = (ImageView) findViewById(R.id.ownerImage);
        ownerName = (TextView) findViewById(R.id.ownerName);
        ownerDescription = (TextView) findViewById(R.id.ownerDescription);

        dogName.setText(profile.getDogName());
        dogBreed.setText(profile.getDogBreed());
        dogGender.setText(String.valueOf(profile.getDogGender()));
        dogDescription.setText(profile.getDogDescription());
        dogImage.setImageResource(profile.getDogPicture());
        ownerImage.setImageResource(profile.getOwnerPicture());
        ownerName.setText(profile.getOwnerName());
        ownerDescription.setText(profile.getOwnerDescription());
    }
}
