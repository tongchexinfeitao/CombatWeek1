package com.bw.combatweek1.contract;

import com.bw.combatweek1.model.ShopBean;

public interface IMyContract {
    interface IView {
        void onMySuccess(ShopBean shopBean);

        void onMyFailure(Throwable throwable);
    }

    interface IModelCallback {
        void onMySuccess(ShopBean shopBean);

        void onMyFailure(Throwable throwable);
    }
}
