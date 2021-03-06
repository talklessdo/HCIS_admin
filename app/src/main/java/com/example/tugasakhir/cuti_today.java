package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugasakhir.Fragment.ApproveCuti;
import com.example.tugasakhir.Fragment.ApproveIzin;
import com.example.tugasakhir.Fragment.CancelCuti;
import com.example.tugasakhir.Fragment.CancelIzin;
import com.example.tugasakhir.Fragment.WaitingCuti;
import com.example.tugasakhir.Fragment.WaitingIzin;
import com.example.tugasakhir.Fragment.fragmentHome;
import com.example.tugasakhir.Helper.PageAdapter;
import com.google.android.material.tabs.TabLayout;

public class cuti_today extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuti_today);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new PageAdapter(getSupportFragmentManager());

        ((PageAdapter) pagerAdapter).AddFragment(new WaitingCuti(),"Menunggu");
        ((PageAdapter) pagerAdapter).AddFragment(new CancelCuti(),"Ditolak");
        ((PageAdapter) pagerAdapter).AddFragment(new ApproveCuti(),"Disetujui");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_time);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_cancel);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_approve);
    }

    public void back(View view) {
        Intent intent = new Intent(this, fragmentHome.class);
    }
}