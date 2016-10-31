package cs188.doggydate;
/*
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
                Intent intent = new Intent(CreateProfileActivity.this, PreferencesActivity.class);
                //intent.putExtra("location", etLocation.getText().toString());
                startActivity(intent);
            }
        });
    }
}


**********************/


        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.graphics.BitmapFactory;
        import android.net.Uri;
        import android.os.Bundle;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

public class CreateProfileActivity extends AppCompatActivity {


    private static int RESULT_LOAD_IMAGE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Button buttonLoadDogImage = (Button) findViewById(R.id.dog_photo_upload);
        buttonLoadDogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        Button buttonLoadOwnerImage = (Button) findViewById(R.id.owner_photo_upload);
        buttonLoadOwnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        Button finished_button = (Button) findViewById(R.id.finished_button);
        finished_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean userHasAccount = true;
                Intent intent = new Intent(CreateProfileActivity.this, PreferencesActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView displayDog = (ImageView) findViewById(R.id.dogPic);
            displayDog.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            ImageView displayOwner = (ImageView) findViewById(R.id.ownerPic);
            displayOwner.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }






}
