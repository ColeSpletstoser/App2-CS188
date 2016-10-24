package cs188.doggydate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Spletz on 10/20/16.
 */
public class HomeFragment extends Fragment {

    private ImageButton dogImageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.home_fragment, container, false);

        ImageButton dogImageButton = (ImageButton) layout.findViewById(R.id.dogImageButton);

        dogImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                startActivity(intent);
            }
        });

        return layout;
    }

}
