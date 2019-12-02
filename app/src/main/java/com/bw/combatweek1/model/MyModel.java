package com.bw.combatweek1.model;

import com.bw.combatweek1.contract.IMyContract;
import com.bw.combatweek1.util.NetUtil;
import com.google.gson.Gson;

public class MyModel {
    public void getMyData(final IMyContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/shop/shop1.json", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
                iModelCallback.onMySuccess(shopBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onMyFailure(throwable);
            }
        });
    }
}
