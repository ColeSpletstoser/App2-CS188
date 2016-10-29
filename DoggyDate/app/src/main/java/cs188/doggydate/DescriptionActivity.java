package cs188.doggydate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private TextView dogName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Profile profile = (Profile) getIntent().getSerializableExtra("Profile");

        dogName = (TextView) findViewById(R.id.dogName);

        dogName.setText(profile.getDogName());
    }
}
