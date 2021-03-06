package com.example.user.CURIFY;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Recipes extends AppCompatActivity {

    /*private RecipesDataSource ds;
    private ListView recipesListView;*/

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        /*ds = new RecipesDataSource();
        recipesListView = (ListView)findViewById(R.id.lvresep);
        recipesListView.setAdapter(new RecipesDataSourceAdapter(this, ds));*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        ListView list;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.recipes_fragment, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.tvresep);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            Log.d(getFragmentManager().toString(), "Fragment Section 2");
            final String[] itemname = new String[]{
                    getContext().getString(R.string.resep1),
                    getContext().getString(R.string.resep2),
                    getContext().getString(R.string.resep3),
                    getContext().getString(R.string.resep4),
                    getContext().getString(R.string.resep5),
                    getContext().getString(R.string.resep6),
                    getContext().getString(R.string.resep7),
                    "",
            };
            Integer[] imgid = {
                    R.drawable.resep1,
                    R.drawable.resep2,
                    R.drawable.resep3,
                    R.drawable.resep4,
                    R.drawable.resep5,
                    R.drawable.resep6,
                    R.drawable.resep7,
                    Integer.valueOf("0"),
            };
            final String[] descrecipe = new String[]{
                    getContext().getString(R.string.rdesc1),
                    getContext().getString(R.string.rdesc2),
                    getContext().getString(R.string.rdesc3),
                    getContext().getString(R.string.rdesc4),
                    getContext().getString(R.string.rdesc5),
                    getContext().getString(R.string.rdesc6),
                    getContext().getString(R.string.rdesc7),
                    "",
            };

            //ArrayAdapter<String> adapter = new ArrayAdapter<String>()
            CustomListAdapter adapter = new CustomListAdapter(getActivity(), itemname, imgid, descrecipe);
            list = (ListView) rootView.findViewById(R.id.lvresep);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    //String Slecteditem = itemname[+position];
                    //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                    /*Intent intent = new Intent(view.getContext(), RecipesItemClick.class);
                    intent.putExtra("itemname", list.getItemAtPosition(position).toString());
                    startActivity(intent);*/
                    ViewGroup vg = (ViewGroup) view;
                    TextView tv = (TextView) vg.findViewById(R.id.rlist_text);

                }
            });
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Recipes";
                case 1:
                    return "Favorites";
            }
            return null;
        }
    }
}
