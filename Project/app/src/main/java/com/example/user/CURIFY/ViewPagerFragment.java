package com.example.user.CURIFY;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 06/01/2017.
 */

public class ViewPagerFragment extends Fragment {
    private ImageView imageView;
    private TextView textView;
    private static String[] phoneTypes = {"Android", "iOS", "WindowsPhone", "BlackBerry", "Tizen", "Ubuntu phone", "Sailfish"};
    private static int[] drawables = {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery, R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_camera};

    public static ViewPagerFragment getInstances(int position) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_carousel, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int position = getArguments().getInt("position");

        imageView = (ImageView) view.findViewById(R.id.image);
        textView = (TextView) view.findViewById(R.id.text_view);

        imageView.setImageResource(drawables[position]);
        textView.setText(phoneTypes[position]);
    }
}
