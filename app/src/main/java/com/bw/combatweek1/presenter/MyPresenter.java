package com.bw.combatweek1.presenter;

import com.bw.combatweek1.contract.IMyContract;
import com.bw.combatweek1.model.MyModel;
import com.bw.combatweek1.model.ShopBean;

public class MyPresenter {

    private MyModel myModel;

    public void getMyData(final IMyContract.IView iView) {
        myModel = new MyModel();
        myModel.getMyData(new IMyContract.IModelCallback() {
            @Override
            public void onMySuccess(ShopBean shopBean) {
                iView.onMySuccess(shopBean);
            }

            @Override
            public void onMyFailure(Throwable throwable) {
                iView.onMyFailure(throwable);
            }
        });
    }
}
