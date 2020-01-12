package com.example.green;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("this is the home Activity");
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_store, R.id.navigation_recycle, R.id.navigation_events, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        System.out.println(getUsername());
        System.out.println(getPassword());
        System.out.println(getBalance());
    }
    private String getUsername() {
        Intent intent = getIntent();
        return intent.getStringExtra("username");
    }
    private String getPassword() {
        Intent intent = getIntent();
        return intent.getStringExtra("password");
    }
    private String getBalance() {
        Intent intent = getIntent();
        return intent.getStringExtra("balance");
    }
}