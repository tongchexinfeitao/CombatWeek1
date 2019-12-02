package com.bw.combatweek1.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.combatweek1.R;
import com.bw.combatweek1.base.BaseFragment;
import com.bw.combatweek1.util.NetUtil;

public class HomeFragment extends BaseFragment {


    private TextView textView;
    private ImageView imageView;

    @Override
    protected void initView(View inflate) {
        textView = inflate.findViewById(R.id.tv);
        imageView = inflate.findViewById(R.id.img);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().hasNet(getActivity())) {
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

}
