package edu.purdue.vieck.animationsondisplay;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by vieck on 6/16/15.
 */
public class AnimationFragment extends Fragment {

    private ImageView aperatureView;
    private boolean isRunning;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.aperature_animation, container, false);

        isRunning = false;

        aperatureView = (ImageView) v.findViewById(R.id.aperature);
        aperatureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable vector = aperatureView.getDrawable();
                if (vector instanceof Animatable) {
                    if (isRunning) {
                        ((Animatable) vector).stop();
                        isRunning = false;
                    } else {
                        ((Animatable) vector).start();
                        isRunning = true;
                    }

                }
            }
        });
        return v;
    }
}
