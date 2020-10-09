package com.curso.petragram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.curso.petragram.adapter.PageAdapter;
import com.curso.petragram.vista.fragment.PerfilFragment;
import com.curso.petragram.vista.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static Context parentContext;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentContext = getApplicationContext();

        miActionBar = findViewById(R.id.miActionBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();



        if (miActionBar != null) {
            setSupportActionBar(miActionBar);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.action_estrella:
            Intent intent1 = new Intent(this, SegundaActivity.class);
            this.startActivity(intent1);
            return(true);
        case R.id.contacto:
            Intent intent2 = new Intent(this, ContactoActivity.class);
            this.startActivity(intent2);
            return(true);
        case R.id.acerca_de:
            Intent intent3 = new Intent(this, BioActivity.class);
            this.startActivity(intent3);
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.cat);

    }



}