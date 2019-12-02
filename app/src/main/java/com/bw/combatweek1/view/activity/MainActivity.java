package com.bw.combatweek1.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bw.combatweek1.R;
import com.bw.combatweek1.base.BaseActivity;
import com.bw.combatweek1.view.fragment.HomeFragment;
import com.bw.combatweek1.view.fragment.MyFragment;
import com.bw.combatweek1.view.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initData() {
        fragmentList.add(new HomeFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new MyFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtn_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rbtn_new:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rbtn_my:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    public void toMyPage() {
        viewPager.setCurrentItem(2);
    }
}
