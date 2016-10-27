package cs188.doggydate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateProfileActivity extends AppCompatActivity {
    private Button finished_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        finished_button = (Button) findViewById(R.id.finished_button);

        finished_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean userHasAccount = true;
                //EditText etLocation = (EditText) findViewById(R.id.et_location);
                Intent intent = new Intent(CreateProfileActivity.this, HomePage.class);
                //intent.putExtra("location", etLocation.getText().toString());
                startActivity(intent);
            }
        });
    }
}
