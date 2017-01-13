package com.example.user.CURIFY;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.GridView;

import com.cleveroad.splittransformation.SquareViewPagerIndicator;
import com.cleveroad.splittransformation.TransformationAdapterWrapper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.*;
import java.util.Calendar;


public class Home extends AppCompatActivity{

    private ViewPager viewPager;
    private SquareViewPagerIndicator indicator;

    //Products_Grid
    private TabHost myTabHost;
    Button button;
    private List<HfProduct> products = new ArrayList<HfProduct>();
    private GridView gridViewProduct;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewPager = (ViewPager) findViewById(R.id.pager);
        indicator = (SquareViewPagerIndicator) findViewById(R.id.indicator);

        //Initializing an adapter and wrap it to TransformationAdapterWrapper
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        TransformationAdapterWrapper wrapper = TransformationAdapterWrapper
                .wrap(this, adapter) //wrap existing page adapter
                .rows(10) //number of rows to split image.
                .columns(7) // number of columns to split image
                .marginTop(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin))
                .build(); //initializing

        viewPager.setAdapter(wrapper);
        viewPager.setPageTransformer(false, wrapper); //never forget this important line!
        indicator.initializeWith(viewPager); //attaching indicator with ViewPager

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);
            drawerLayout.closeDrawers();
            int id = item.getItemId();
            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                // pilihan menu item navigasi akan menampilkan pesan toast klik kalian bisa menggantinya
                //dengan intent activity
                case R.id.nav_home:
                    Intent home = new Intent(Home.this,Home.class);
                    startActivity(home);
                    return true;
                case R.id.nav_myschedule:
                    Intent cal = new Intent(Home.this,MsCalendar.class);
                    startActivity(cal);
                    return true;
                case R.id.nav_healthyfair:
                    //OldHealthyFair fraghfair = OldHealthyFair.newInstance("some1","some2");
                    //manager.beginTransaction().replace(R.id.content_main,fraghfair,fraghfair.getTag()).commit();
                    Intent hf = new Intent(Home.this, OldHealthyFair.class);
                    startActivity(hf);
                    return true;
                case R.id.btnViewProfile:
                    Intent profile = new Intent(Home.this,IdProfile.class);
                    startActivity(profile);
                    return true;
                case R.id.nav_recipes:
                    Intent resep = new Intent(Home.this,Recipes.class);
                    startActivity(resep);
                    return true;
                case R.id.nav_fitforyou:
                    Intent ffu = new Intent(Home.this,FitForYou.class);
                    startActivity(ffu);
                    return true;
                case R.id.nav_points:
                    Intent pts = new Intent(Home.this,PointSystem.class);
                    startActivity(pts);
                    return true;
                case R.id.nav_checkup:
                    Intent cup = new Intent(Home.this,CheckUp.class);
                    startActivity(cup);
                    return true;
                case R.id.nav_feedback:
                    Intent feedback = new Intent(Home.this, Feedback.class);
                    startActivity(feedback);
                    return true;
                case R.id.nav_share:
                    Toast.makeText(getApplicationContext(), "Share telah dipilih", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.nav_send:
                    Toast.makeText(getApplicationContext(), "Send telah dipilih", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    Toast.makeText(getApplicationContext(), "Kesalahan Terjadi ", Toast.LENGTH_SHORT).show();
                    return true;
            }
        }
        });
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                // Kode di sini akan merespons setelah drawer menutup disini kita biarkan kosong
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                //  Kode di sini akan merespons setelah drawer terbuka disini kita biarkan kosong
                super.onDrawerOpened(drawerView);
            }
        };
        //Mensetting actionbarToggle untuk drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //memanggil synstate
        actionBarDrawerToggle.syncState();
        /*
        //Products Grid
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);
            gridViewProduct = (GridView) findViewById(R.id.gridViewProduct);
            initData();
            drawDatatoGridView();*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }
    public void goToProfile(View view){
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);

        Intent intent = new Intent(this,IdProfile.class);
        startActivity(intent);
    }

    private static class SimplePagerAdapter extends FragmentStatePagerAdapter {

        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ViewPagerFragment.getInstances(position);
        }

        @Override
        public int getCount() {
            return 7;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
