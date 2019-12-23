package com.wiser.selfheighviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.wiser.self_vp.SelfHeightViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    SelfHeightViewPager vp;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments.add(TestFragment.getInstance(getList(20)));
        fragments.add(TestFragment.getInstance(getList(10)));

        vp = findViewById(R.id.vp);
        vp.setAdapter(new VpAdapter(getSupportFragmentManager(),0,fragments));

        vp.addOnPageChangeListener(this);
    }

    private List<String> getList(int size){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("第"+i+"条");
        }
        return list;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        vp.resetHeight(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
