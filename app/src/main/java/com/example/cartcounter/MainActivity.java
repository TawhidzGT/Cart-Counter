package com.example.cartcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DrawerLayout dl;
    public static NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel mAVM = ViewModelProviders.of(this).get(mainActivityViewModel.class);

        dl = findViewById(R.id.drawerLayout);
        final NavigationView myNav = findViewById(R.id.nav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(toggle);
        toggle.syncState();


        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tablayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(bottomNavigation);

        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setNavigationIcon(null);
        setSupportActionBar(toolbar);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        navController= Navigation.findNavController(this,R.id.nav_host_fragment);


     /*   NavigationUI.setupWithNavController(navigation,navController);
        NavigationUI.setupWithNavController(myNav,navController);*/

        myNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_left:
                        dl.closeDrawer(GravityCompat.START);
                        bottomNavigation.setSelectedItemId(R.id.navigation_left);
                        navController.navigate(R.id.navigation_left);
                        break;
                    case R.id.navigation_leftCenter:
                        dl.closeDrawer(GravityCompat.START);
                        bottomNavigation.setSelectedItemId(R.id.navigation_leftCenter);
                        navController.navigate(R.id.navigation_leftCenter);
                        break;
                    case R.id.navigation_RightCenter:
                        dl.closeDrawer(GravityCompat.START);
                        bottomNavigation.setSelectedItemId(R.id.navigation_RightCenter);
                        navController.navigate(R.id.navigation_RightCenter);
                        break;
                    case R.id.navigation_right:
                        dl.closeDrawer(GravityCompat.START);
                        bottomNavigation.setSelectedItemId(R.id.navigation_right);
                        navController.navigate(R.id.navigation_right);
                        break;
                }

                return true;

            }
        });


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_left:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_leftCenter:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_RightCenter:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_right:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return  true;
            }
        });



        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch(tab.getPosition())
                {
                    case 0:
                        bottomNavigation.setSelectedItemId(R.id.navigation_left);
                        navController.navigate(R.id.navigation_left);
                        break;
                    case 1:
                        bottomNavigation.setSelectedItemId(R.id.navigation_leftCenter);
                        navController.navigate(R.id.navigation_leftCenter);
                        break;
                    case 2:
                        bottomNavigation.setSelectedItemId(R.id.navigation_RightCenter);
                        navController.navigate(R.id.navigation_RightCenter);
                        break;
                    case 3:
                        bottomNavigation.setSelectedItemId(R.id.navigation_right);
                        navController.navigate(R.id.navigation_right);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
