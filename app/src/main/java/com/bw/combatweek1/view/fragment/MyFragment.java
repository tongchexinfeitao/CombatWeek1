package com.bw.combatweek1.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.bw.combatweek1.R;
import com.bw.combatweek1.base.BaseFragment;
import com.bw.combatweek1.contract.IMyContract;
import com.bw.combatweek1.model.ShopBean;
import com.bw.combatweek1.presenter.MyPresenter;
import com.bw.combatweek1.view.adapter.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements IMyContract.IView {


    private GridView gridView;
    private MyPresenter myPresenter;

    @Override
    protected void initView(View inflate) {
        gridView = inflate.findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        myPresenter = new MyPresenter();
        myPresenter.getMyData(this);
    }

    @Override
    public void onMySuccess(ShopBean shopBean) {
        Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
        gridView.setAdapter(new MyAdapter(shopBean.getData()));
    }

    @Override
    public void onMyFailure(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
    }
}
