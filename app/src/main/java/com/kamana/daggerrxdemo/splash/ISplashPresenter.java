package com.kamana.daggerrxdemo.splash;

import com.kamana.daggerrxdemo.base.IBasePresenter;
import com.kamana.daggerrxdemo.di.PerActivity;

/**
 * Created by kamana on 26/6/18.
 */

@PerActivity
public interface ISplashPresenter<T extends ISplashView> extends IBasePresenter<T> {

    void getCustomerData();
}
