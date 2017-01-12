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
    private TextView textView,textView2;
    private static String[] phoneTypes = {"Health with Benefit", "New Recipes Available!", "New Arrival", "Calories Alert", "[EVENT]Win a Trip to Maldives ", "Help Us with Your Feedback", "Check your Bodies"};
    private static String[] desc = {"Many additional missions added! Check it out :)",
            "More than 30++ recipes added.",
            "Additional 50++ items are added for sale",
            "Always remember to check the calories of your daily consumptions as per recommended",
            "You want to go to Maldives for free? Then join this event!",
            "Your satisfaction is our TOP priority. Help us to improve by giving some feedbacks :)",
            "Fit for you is here to help you to know the best ideal body that suits you"};
    private static int[] drawables = {R.drawable.carousel_1, R.drawable.carousel_2, R.drawable.carousel_3,
            R.drawable.carousel_4, R.drawable.carousel_5, R.drawable.carousel_6, R.drawable.carousel_7};

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
        textView2 = (TextView)view.findViewById(R.id.small_desc);
        imageView.setImageResource(drawables[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        textView.setText(phoneTypes[position]);
        textView2.setText(desc[position]);
    }
}
