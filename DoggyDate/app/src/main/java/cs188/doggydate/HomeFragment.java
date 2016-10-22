package cs188.doggydate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Spletz on 10/20/16.
 */
public class HomeFragment extends Fragment {

    private ImageButton dogImageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        dogImageButton = (ImageButton) getView().findViewById(R.id.dogImageButton);
        dogImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do what you want to happen when the button is clicked
            }
        });


        return inflater.inflate(R.layout.home_fragment, container, false);
    }

}
